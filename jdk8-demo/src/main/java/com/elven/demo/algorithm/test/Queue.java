package com.elven.demo.algorithm.test;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Queue {
    Node first, last;

    public Node peek(){
        if(first != null){
            return first;
        }
        return null;
    }

    public void offer(Node node){
        if(first == null){
            first = node;
            last = first;
        }
        else{
            last.next = node;
            last = node;
        }
    }

    public Node poll(){
        if(first != null){
            Node temp = new Node(first.value);
            first = first.next;
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            queue.offer(node);
            System.out.println(":::peek:::"+queue.peek().value);
        }

        Node node = null;
        while ((node = queue.poll()) != null){
            System.out.println(":::poll:::"+node.value);
        }
    }
}
