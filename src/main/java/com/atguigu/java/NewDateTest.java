package com.atguigu.java;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

/*
 	jdk1.8之前日期时间API的问题 ：
 */
public class NewDateTest {

	/*
	 * jdk1.8之前日期时间API的问题 ： 偏移性：Date中的年份是从1900开始的，而月份都从0开始。
	 * 
	 */
	@Test
	public void test() {
		Date date = new Date(2019, 3, 8);
		System.out.println(date);
	}

	/*
	 * jdk1.8之前日期时间API的问题 ：可变性：像日期和时间这样的类应该是不可变的
	 */
	@Test
	public void test2() {
		// 获取对象 - 多态
		Calendar calendar = Calendar.getInstance();
		

		// 在当天是当月的第几天的基础上加或者减一些天数
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		
		// 获取当天是当月的第几天
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);

		
		calendar.add(Calendar.DAY_OF_MONTH, 4);
		// 获取当天是当月的第几天
		day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);

	}
}
