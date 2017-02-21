package com.elven.demo.jdk8.test;

import java.util.*;

/**
 * Created by Administrator on 2016/10/24.
 */
public class StackQueueTest {
    public static void main(String[] args) {
//        stackTest();
        queueTest();
    }

    public static void stackTest() {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }


        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    public static void queueTest(){
        Queue queue = new LinkedList();

        for (int i = 0; i < 10; i++) {
            queue.offer(new Integer(i));
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
