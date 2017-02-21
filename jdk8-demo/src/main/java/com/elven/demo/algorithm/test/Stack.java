package com.elven.demo.algorithm.test;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Stack {
    Node top;

    public Node peek(){
        return top;
    }

    public Node pop(){
        if(top != null){
            Node temp = new Node(top.value);
            top = top.next;
            return temp;
        }
        return null;
    }

    public void push(Node node){
        if (node != null){
            Node temp = top;
            node.next = top;
            top = node;
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            stack.push(node);
            System.out.println("peek:::"+stack.peek().value);
        }

        Node top = null;
        while ((top = stack.pop()) != null){
            System.out.println("pop:::"+top.value);
        }

    }
}
