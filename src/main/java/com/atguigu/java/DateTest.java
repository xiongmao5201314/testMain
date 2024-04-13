package com.atguigu.java;

public class DateTest {

	public static void main(String[] args) {
		
		
		A a = new C();
		C c = (C) a; //可以 - 变成了本态
		B b = (B)a; //多态
		
		System.out.println("---------------------");
		
		
		A aa = new A();
		B bb = (B)aa;//不对
		
	}
}

class A{
	
}

class B extends A{
	
}


class C extends B{
	
}