package com.elven.demo.jdk8.test;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Stack2Queue {
    /**
     * 入
     */
    Stack stack1 = new Stack();
    /**
     * 出
     */
    Stack stack2 = new Stack();

    public void in2out(){
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }

    public void out2in(){
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    public Object peek(){
        if(!stack1.empty()){
            in2out();
        }

        if(!stack2.empty()){
            return stack2.peek();
        }

        return null;
    }

    public void offer(Object object){
        if(!stack2.empty()){
            out2in();
        }
        stack1.push(object);
    }

    public Object poll(){
        if(!stack1.empty()){
            in2out();
        }

        if(!stack2.empty()){
            return stack2.pop();
        }
        return null;
    }

    public boolean isEmpty(){
        if(!stack1.empty()){
            in2out();
        }

        return stack2.empty();
    }

    public static void main(String[] args) {
        Stack2Queue queue = new Stack2Queue();

        for (int i = 0; i < 10; i++) {
            queue.offer(new Integer(i));
            System.out.println("::::queue.peek()::"+queue.peek());
        }

        while (!queue.isEmpty()){
            System.out.println("::::queue.poll()::"+queue.poll());
        }

    }
}
