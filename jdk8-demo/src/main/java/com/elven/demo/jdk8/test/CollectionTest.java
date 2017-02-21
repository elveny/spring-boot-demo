package com.elven.demo.jdk8.test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/20.
 */
public class CollectionTest {
    public static void main(String[] args) {
        System.out.println("linkedListTest:::::::::::::");
        linkedListTest();

//        System.out.println("arrayListTest:::::::::::::");
//        arrayListTest();

//        System.out.println("linkedListStackTest:::::::::::::");
//        linkedListStackTest();
//
//        System.out.println("linkedListQueueTest:::::::::::::");
//        linkedListQueueTest();

    }

    public static void linkedListTest(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.add(3, 10);

        System.out.println(list);

        System.out.println("::::::list.getFirst()::::::"+list.getFirst());
        System.out.println("::::::list.getLast()::::::"+list.getLast());
        System.out.println("::::::list.pop()::::::"+list.pop());
        System.out.println("::::::list.pop()::::::"+list.pop());
        System.out.println("::::::list.getFirst()::::::"+list.getFirst());
        System.out.println("::::::list.offerFirst()::::::"+list.offerFirst(11));

        System.out.println(list);

        System.out.println("::::::list.pollFirst()::::::"+list.pollFirst());

        System.out.println(list);

        list.push(12);
        System.out.println(list);

        list.poll();
        System.out.println(list);

        list.pop();
        System.out.println(list);

        Integer[] my = list.toArray(new Integer[0]);
        for (int i = 0; i < my.length; i++) {
            System.out.println(my[i]);
        }

        Integer[] my1 = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < my.length; i++) {
            System.out.println(my1[i]);
        }
    }

    public static void arrayListTest(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.add(3, 10);

        System.out.println(list);

        System.out.println("::::::list.getFirst()::::::");
        System.out.println("::::::list.getLast()::::::");
    }

    public static void linkedListStackTest(){
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));

            System.out.println("stack.peek()::::::"+stack.peek());
        }

        Object object = null;

        while ((object = stack.pop()) != null){
            System.out.println("stack.pop()::::::"+object);
        }
    }

    public static void linkedListQueueTest(){
        LinkedListQueue queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.offer(new Integer(i));

            System.out.println("queue.peek()::::::"+queue.peek());
        }

        Object object = null;

        while ((object = queue.poll()) != null){
            System.out.println("queue.poll()::::::"+object);
        }
    }
}

class LinkedListStack{
    private LinkedList<Object> list = new LinkedList<Object>();

    public Object peek(){
        return list.getFirst();
    }

    public void push(Object object){
        list.addFirst(object);
    }

    public Object pop(){
        return list.pollFirst();
    }
}

class LinkedListQueue{
    private LinkedList<Object> list = new LinkedList<Object>();

    public Object peek(){
        return list.getFirst();
    }

    public void offer(Object object){
        list.addLast(object);
    }

    public Object poll(){
        return list.pollFirst();
    }
}
