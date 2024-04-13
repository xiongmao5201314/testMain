package com.atguigu.java4;


@MyAnn2
@MyAnn(name = "com.atguigu.java4.Dog")
public class Dog extends Animal{

	public Dog(){
		System.out.println("狗狗的空参构造器");
	}
	
	private Dog(int a){
		System.out.println("狗狗的构造器" + a);
	}
	
	private String dogName;
	
	@MyAnn(name = "10")
	public int dogAge;
	
	private void dogInfo(){
		System.out.println("private dogInfo");
	}
	
	public void dogSay(int a){
		System.out.println("public dogSay " + a);
	}
	
	
	public void test(){
		System.out.println("dogAge=" + dogAge + " dogName=" + dogName);
	}
}
