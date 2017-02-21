package com.elven.demo.jdk8.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Queue2Stack {

    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();

    public Object peek(){
        Object obj = null;
        if(!queue1.isEmpty()){
            int n = queue1.size();
            for (int i = 0; i < n; i++) {
                if(i == (n-1)){
                    obj = queue1.peek();
                }
                queue2.offer(queue1.poll());
            }
        }
        else if(!queue2.isEmpty()){
            int n = queue2.size();
            for (int i = 0; i < n; i++) {
                if(i == (n-1)){
                    obj = queue2.peek();
                }
                queue1.offer(queue2.poll());
            }
        }

        return obj;
    }

    public void push(Object object){
        if(!queue1.isEmpty()){
            queue1.offer(object);
        }
        else{
            queue2.offer(object);
        }
    }

    public Object pop(){
        Object obj = null;
        if(!queue1.isEmpty()){
            int n = queue1.size();
            for (int i = 0; i < n; i++) {
                if(i == (n-1)){
                    obj = queue1.poll();
                }
                else{
                    queue2.offer(queue1.poll());
                }
            }
        }
        else if(!queue2.isEmpty()){
            int n = queue2.size();
            for (int i = 0; i < n; i++) {
                if(i == (n-1)){
                    obj = queue2.poll();
                }
                else{
                    queue1.offer(queue2.poll());
                }

            }
        }

        return obj;
    }

    public boolean empty(){

        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
            System.out.println(":::stack.peek():::"+stack.peek());
        }

        while (!stack.empty()){
            System.out.println(":::stack.pop():::"+stack.pop());
        }

    }
}
