package com.atguigu.java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;


public class NewDateTest2 {
	
	/*
	 * DateTimeFormatter : 用来格式化日期和时间
	 */
	@Test
	public void test3(){
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		//预定义的标准格式
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		//本地化相关的格式
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		//自定义
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		//将日期时间转成字符串
		String str = dtf.format(localDateTime);
		System.out.println(str);
		
		//将字符串转化成日期和时间
		TemporalAccessor parse = dtf.parse("2019-11-09 10:35:22");
		System.out.println(parse);
	}
	
	/*
	 * Instant
	 */
	@Test
	public void test2(){
		//静态方法，返回默认UTC时区的Instant类的对象
		Instant now = Instant.now();
		System.out.println(now);
		
		//获取毫秒数对应的时间
		Instant ofEpochMilli = Instant.ofEpochMilli(1522221444444L);
		System.out.println(ofEpochMilli);
		
		//获取时间所对应的毫秒数
		long epochMilli = now.toEpochMilli();
		System.out.println(epochMilli);
		
		//结合即时的偏移来创建一个 OffsetDateTime
		OffsetDateTime atOffset = now.atOffset(ZoneOffset.ofHours(8));
		System.out.println(atOffset);
	}

	/*
 		LocalDate,LocalTime,LocalDateTime
	 */
	@Test
	public void test(){
		//根据当前时间创建对象/指定时区的对象
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		
		System.out.println("----------------------------------------");
		
		//根据指定日期/时间创建对象
		LocalDate localDate2 = LocalDate.of(2019, 3, 8);
		System.out.println(localDate2);
		
		
		System.out.println("--------------------------------------");
		//获取当天是当年的第几天
		int day = localDate.getDayOfYear();
		System.out.println(day);
		
		
		System.out.println("--------------------------------------");
		//获取年份
		int year = localDate.getYear();
		//获取月份
		int monthValue = localDate.getMonthValue();
		System.out.println(monthValue);
		
		//获取几点（只有小时）
		System.out.println(localTime.getHour());
		
		System.out.println("--------------------------------------");
		//设置当天是当月的第几天
		LocalDate withDayOfMonth = localDate.withDayOfMonth(2);
		System.out.println(withDayOfMonth);
		
		System.out.println(localDate);
		
		System.out.println("--------------------------------------");
		//在当天是当月的第几天的基础上加上x天
		LocalDate plusDays = localDate.plusDays(2);
		System.out.println(plusDays);
	}
}
