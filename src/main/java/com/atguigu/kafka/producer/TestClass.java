package com.atguigu.kafka.producer;
class A {
    String a="10";
    int b =20;

    public void info(){
        System.out.println("A.info");
    }

}
class B extends  A{
    String c ="c";
    String a ="11";
    @Override
    public void info(){
        System.out.println("B.info");
    }
}
public class TestClass {
    public static void main(String[] args) {
        char[] chars = "abc".toCharArray();
        byte[] bytes = "abc".getBytes();
        for (byte abyte : bytes) {
            System.out.println(abyte);

        }
        int a=10;
        a =a++ + ++a;
        System.out.println(a);
//        System.out.println(sum);
    }
}
