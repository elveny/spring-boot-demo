package com.elven.demo.jdk8.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/10/15.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        printClassTypeInfo("com.elven.demo.jdk8.test.MyHelloWorld");

//        createInstanceTest("com.elven.demo.jdk8.test.MyHelloWorld");
//        invokeMethodTest("com.elven.demo.jdk8.test.MyHelloWorld");
        setFieldTest("com.elven.demo.jdk8.test.MyHelloWorld");
    }

    private static void setFieldTest(String type) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
        Class classType = Class.forName(type);
        MyHelloWorld hello = (MyHelloWorld) classType.newInstance();
        System.out.println("name is " + hello.name);
        Field field = classType.getField("name");
        field.set(hello, "Zhang San");
        System.out.println("name is " + hello.name);
    }

    private static void invokeMethodTest(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class classType = Class.forName(type);
        MyHelloWorld hello = (MyHelloWorld) classType.newInstance();
        Method method = classType.getMethod("sayHello", new Class[]{String.class});
        method.invoke(hello, new Object[]{"Zhang San"});
    }


    private static void printClassTypeInfo(String type) throws ClassNotFoundException {
        Class classType = Class.forName(type);
        Method[] methods = classType.getDeclaredMethods();
        System.out.println("Methods info as below:");
        for (Method method : methods) {
            System.out.println(method.toGenericString());
        }
        Field[] fields = classType.getFields();
        System.out.println("Fields info as below:");
        for (Field field : fields) {
            System.out.println(field.toGenericString());
        }
    }

    private static void createInstanceTest(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class classType = Class.forName(type);
        MyHelloWorld hello = (MyHelloWorld) classType.newInstance();
        hello.sayHello("Zhang San");
    }

}

interface HelloWorldService {
    void sayHello(String name);
}

class MyHelloWorld implements HelloWorldService {
    public String name;


    public void sayHello(String name) {
        System.out.println("Hello " + name + ".");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
