package com.elven.demo.algorithm.test;

/**
 * Created by wuqs on 2016/10/24.
 */
public class Queue2Stack {
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    public Queue2Stack(){

    }

    public void push(Node node){
        if(queue1.first != null){
            queue1.offer(node);
        }
        else{
            queue2.offer(node);
        }
    }

    public Node pop(){
        Node result = null;
        if(queue1.first != null){
            Node node = null;
            while ((node = queue1.poll()) != null){
                if(node.next != null){
                    queue2.offer(node);
                }
                else{
                    result = node;
                }
            }
        }
        else if(queue2.first != null){
            Node node = null;
            while ((node = queue2.poll()) != null){
                if(node.next != null){
                    queue1.offer(node);
                }
                else{
                    result = node;
                }
            }
        }

        return result;
    }

    public Node peek(){
        Node result = null;
        if(queue1.first != null){
            Node node = null;
            while ((node = queue1.poll()) != null){
                queue2.offer(node);
                if(node.next == null){
                    result = node;
                }
            }
        }
        else if(queue2.first != null){
            Node node = null;
            while ((node = queue2.poll()) != null){
                queue1.offer(node);
                if(node.next == null){
                    result = node;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();

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
