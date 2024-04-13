package com.atguigu.java2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/*
 	反射 - 演示
 	
 	反射重点 ： 1.如何获取Class实例     2.通过反射获取属性和方法   3.通过反射调用指定属性和方法
 */
public class ReflectionTest {

	@Test
	public void test() throws Exception, Exception{
		
		Person person = new Person();
	
		//通过反射调用私有属性和私有方法
		Class clazz = Person.class;
		//获取私有的属性
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(person, "小龙哥");
		
		
//		person.info();
		
		//通过反射调用私有的方法
		Method declaredMethod = clazz.getDeclaredMethod("test");
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(person);
		
	}
}
