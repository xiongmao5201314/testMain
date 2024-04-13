package com.atguigu.java;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class OtherTest {
	
	/*
	 * 一般的Float类和Double类可以用来做科学计算或工程计算
		但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。
	 */
	@Test
	public void test3(){
		System.out.println(1 - 0.41);
		
		System.out.println("-----------------------------------");
		
		BigDecimal a = new BigDecimal(String.valueOf(1));
		BigDecimal b = new BigDecimal(String.valueOf(0.41));
		BigDecimal subtract = a.subtract(b);
		System.out.println(subtract);
	}
	/*
	 * Integer类作为int的包装类，能存储的最大整型值为231-1，Long类也是有限的，最大为263-1。如果要表示再大的整数，
	 * 不管是基本数据类型还是他们的包装类都无能为力，更不用说进行运算了。
	 */
	@Test
	public void test2(){
		int maxValue = Integer.MAX_VALUE;
		System.out.println(maxValue);//2147483647
		
		maxValue += 1;
		System.out.println(maxValue);
		
		System.out.println("---------------------------------------------");
		
		BigInteger a = new BigInteger(String.valueOf(2147483647));
		BigInteger b = new BigInteger(String.valueOf(1));
		BigInteger sum = a.add(b);
		System.out.println(sum);
	}

	/*
	 * java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回值类型一般为double型。
	 */
	@Test
	public void test(){
		
	}
}
