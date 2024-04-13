package com.atguigu.java5;

import org.junit.Test;

/*
 	1.获取类加载器
 	2.验证某个类是由哪个类加载器加载的
 */
public class LoadClassTest {

	@Test
	public void test() throws ClassNotFoundException{
		//1.获取一个系统类加载器
		ClassLoader classloader = ClassLoader.getSystemClassLoader();
		System.out.println(classloader);
		//2.获取系统类加载器的父类加载器，即扩展类加载器
		classloader = classloader.getParent();
		System.out.println(classloader);
		//3.获取扩展类加载器的父类加载器，即引导类加载器
		classloader = classloader.getParent();
		System.out.println(classloader);
		//4.测试当前类由哪个类加载器进行加载
		classloader = Class.forName("java.lang.String").getClassLoader();
		System.out.println(classloader);

	}
}
