package com.atguigu.java3;

import org.junit.Test;

import com.atguigu.java2.Person;

public class ClassTest {

	
	/*
	 * Class : 
	 * 		1.Class是反射的源头 - （要想使用反射必先儿取该类的Class对象）
	 * 		2.Class本身也是一个类
			3.Class 对象只能由系统建立对象
			4.一个加载的类在 JVM 中只会有一个Class实例 
			5.一个Class对象对应的是一个加载到JVM中的一个.class文件
			6.每个类的实例都会记得自己是由哪个 Class 实例所生成
			7.通过Class可以完整地得到一个类中的所有被加载的结构 
			8.Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

	 */
	@Test
	public void test() throws Exception{
		
		//1.获取Class实例的方式一 ： 类名.class
		Class clazz = Person.class;
		//2.获取Class实例的方式二 ：对象名.getClass()
		Class clazz2 = new Person().getClass();
		//3.获取Class实例的方式三 ： Class.forName(全类名)
		Class clazz3 = Class.forName("com.atguigu.java2.Person");
		//4.获取Class实例的方式四 ： 类加器.loadClass(全类名) - 了解
		ClassLoader c = this.getClass().getClassLoader();
		Class clazz4 = c.loadClass("com.atguigu.java2.Person");
		
		System.out.println(clazz == clazz2 && clazz3 == clazz4 && clazz == clazz3);
	}
}
