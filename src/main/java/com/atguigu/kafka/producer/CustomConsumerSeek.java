package com.atguigu.kafka.producer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.util.*;

public class CustomConsumerSeek {
    public static void main(String[] args) {
        // 0 配置信息
        Properties properties = new Properties();
        // 连接
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop102:9092");
        // key value 反序列化

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test2");
        // 1 创建一个消费者
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer(properties);

        // 2 订阅一个主题
        ArrayList<String> topics = new ArrayList();
        topics.add("first");
        kafkaConsumer.subscribe(topics);
        //指定位置进行消费
        Set<TopicPartition> assignment= kafkaConsumer.assignment();

        //保证分区方案指定完毕
        while (assignment.size() == 0) {
            kafkaConsumer.poll(1000);
            // 获取消费者分区分配信息（有了分区分配信息才能开始消费）
            assignment = kafkaConsumer.assignment();
        }
        //希望把时间转换为对应的offset
        HashMap<TopicPartition, Long> topicPartitionLongHashMap = new HashMap<TopicPartition, Long>();

        //封装对应集合
        for (TopicPartition topicPartition : assignment) {
            topicPartitionLongHashMap.put(topicPartition,System.currentTimeMillis()-1*24*3600*1000);
        }
        //希望把时间转换为对应的offset
        Map<TopicPartition, OffsetAndTimestamp> topicPartitionOffsetAndTimestampMap = kafkaConsumer.offsetsForTimes(topicPartitionLongHashMap);
        // 遍历所有分区，并指定 offset 从 1700 的位置开始消费
        for (TopicPartition topicPartition: assignment) {
            OffsetAndTimestamp offsetAndTimestamp = topicPartitionOffsetAndTimestampMap.get(topicPartition);
            long offset = offsetAndTimestamp.offset();
            kafkaConsumer.seek(topicPartition,offset);
        }
        // 3 消费该主题数据
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(1000);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord);
            }
        }
    }
}