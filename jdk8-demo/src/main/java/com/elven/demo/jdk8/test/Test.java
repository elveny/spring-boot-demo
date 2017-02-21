package com.elven.demo.jdk8.test;

/**
 * Created by Administrator on 2016/10/18.
 */
public class Test {
    public static void main(String[] args) {
        new Test1().test();
        Test1 test = new Test2();
        test.test();

    }
}

class Test1{
    public static void test(){
        System.out.println("Test1.test()");
    }
}

class Test2 extends Test1{
    public static void test(){
        System.out.println("Test2.test()");
    }
}