package com.atguigu.java4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;



/*
 * 通过反射获取类中的结构
 */
public class ReflectionTest {
	/*
	 * 通过反射获取指定属性并赋值 - 需要掌握
	 */
	@Test
	public void test3() throws Exception, Exception{
		//创建Dog对象
		Dog dog = new Dog();
		
		Class clazz = Dog.class;
		//获取指定属性
		/*
		 * getField() : 只能获取public所修饰的属性
		 */
//		Field field = clazz.getField("dogAge");
		//给属性赋值
		/*
		 * setInt(对象名，属性值)
		 */
//		field.setInt(dog, 10);
		
		System.out.println("------------------给私有属性赋值----------------------------");
		
		//获取指定的属性
		/*
		 * getDeclaredField() : 可以获取任意权限修饰符修饰的属性
		 */
		Field declaredField = clazz.getDeclaredField("dogName");
		//授权（设置是否允许访问）
		declaredField.setAccessible(true);
		//给属性赋值
		declaredField.set(dog, "中华田园犬");
		
		dog.test();
		
	}
	
	/*
	 * 调用指定的方法 - 需要掌握
	 */
	@Test
	public void test4() throws Exception, Exception{
		
		Dog dog = new Dog();
		
		Class clazz = Dog.class;
		
		//获取指定的方法
		/*
		 * 第一个参数 ：方法名
		 * 第二个参数 ： 形参类型
		 */
//		Method method = clazz.getMethod("dogSay", int.class);
		//调用方法
		/*
		 * 第一个参数 ： 对象名
		 * 第二个参数 ： 实参
		 */
//		method.invoke(dog, 10);
		
		System.out.println("--------------------调用私有的方法---------------------------");
		
		//调用指定的方法 - 
		/*
		 * getDeclaredMethod(String name, Class<?>... parameterTypes) : 
		 * 		可以调用任意权限修饰符修饰的方法
		 * 第一个参数 ： 方法名
		 * 第二个参数 ： 形参的类型
		 */
		Method declaredMethod = clazz.getDeclaredMethod("dogInfo");
		//允许访问
		declaredMethod.setAccessible(true);
		//调用方法
		/*
		 * invoke(Object obj, Object... args) : 调用方法
		 * 第一个参数 ： 对象名
		 * 第二个参数 ： 实参
		 */
		declaredMethod.invoke(dog);
		
	}
	

	/*
	 * 通过反射获取属性
	 */
	@Test
	public void test(){
		//1.先获取Class对象
		Class clazz = Dog.class;
		//2.获取属性
		/*
		 * getFields() : 获取本类及父类中所有public修饰的属性
		 */
		Field[] fields = clazz.getFields();
		//遍历
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		
		System.out.println("--------------------------------------");
		
		/*
		 * getDeclaredFields() : 获取本类中所有的属性
		 */
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for (int i = 0; i < declaredFields.length; i++) {
			System.out.println(declaredFields[i]);
		}
	}
	
	/*
	 * 通过反射获取方法
	 */
	@Test
	public void test2(){
		//1.先获取Class对象
		Class clazz = Dog.class;
		//2.获取类中的方法
		/*
		 * getMethods() ： 获取本类及父类中所有public修饰的方法
		 */
		Method[] methods = clazz.getMethods();
		//遍历
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		
		System.out.println("----------------------------------");
		
		/*
		 * getDeclaredMethods() : 获取本类中所有的方法
		 */
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			System.out.println(declaredMethods[i]);
		}
	}
	
	
	/*
	 * 通过反射获取父类
	 */
	@Test
	public void test5(){
		Class clazz = Dog.class;
		//获取父类 - 获取的是父类的类信息
		Class superclass = clazz.getSuperclass();
	}
	
	/*
	 * 通过反射获取注解
	 */
	@Test
	public void test6() throws Exception, Exception{
		Class clazz = Dog.class;
		//获取的是类上的注解
//		Annotation[] annotations = clazz.getAnnotations();
//		for (int i = 0; i < annotations.length; i++) {
//			System.out.println(annotations[i]);
//		}
		
		//获取属性上的注解 ： ①先获取那个属性   ②再获取注解
		Field field = clazz.getField("dogAge");
		//获取属性上的注解
		Annotation[] annotations2 = field.getAnnotations();
		for (int i = 0; i < annotations2.length; i++) {
//			System.out.println(annotations2[i]);
			//如何获取注解上的那个值
			Annotation annotation = annotations2[i];
			
			MyAnn ma = (MyAnn) annotation;
			
			String s = ma.name();
			
			System.out.println(s);
		}
	}
	
	/*
	 * 通过反获取构造器 - 通过反射创建对象
	 */
	@Test
	public void test7() throws Exception, Exception{
		
		Class clazz = Dog.class;
		//获取指定构造器 - 获取的是空参构造器
//		Constructor constructor = clazz.getConstructor();
		//创建对象
//		constructor.newInstance();
		
		System.out.println("-----------------获取私有带参构造器------------");
		
		/*
		 * 获取指定构造器 - 任意权限修饰符
		 * 
		 * getDeclaredConstructor(Class<?>... parameterTypes) ： 方法形参是构造器形参的类型 
		 */
		Constructor constructor2 = clazz.getDeclaredConstructor(int.class);
		
		constructor2.setAccessible(true);
		/*
		 *  newInstance(Object ... initargs) : 方法的形参是往构造器中传的实参
		 */
		constructor2.newInstance(10);
	}
}





















