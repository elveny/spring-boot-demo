package com.elven.demo.algorithm.test;

/**
 * Created by Administrator on 2016/10/23.
 */
public class Stack2Queue {
    /**
     * 入栈
     */
    Stack stack1 = new Stack();
    /**
     * 出栈
     */
    Stack stack2 = new Stack();

    public Stack2Queue(){

    }

    /**
     * 将“入栈”倒入“出栈”
     */
    public void in2outStack(){
        Node node = null;
        while ((node = stack1.pop()) != null){
            stack2.push(node);
        }
    }
    /**
     * 将“出栈”倒入“入栈”
     */
    public void out2inStack(){
        Node node = null;
        while ((node = stack2.pop()) != null){
            stack1.push(node);
        }
    }

    /**
     *  获取“队列”队首元素
     *  （1）将“入栈”数据倒入到“出栈”中
     *  （2）将“出栈”中的top返回即可。
     * @return
     */
    public Node peek(){

        if(stack2.peek() == null && stack1.peek() != null){
            in2outStack();
        }

        return stack2.peek();
    }

    /**
     * 入“队列”操作
     * （1）将“出栈”倒入“入栈”
     * （2）在“入栈”中压入数据
     * @param node
     */
    public void offer(Node node){
        if(stack2.peek() != null){
            out2inStack();
        }

        stack1.push(node);
    }

    /**
     * 出“队列”操作
     * （1）将“入栈”数据倒入“出栈”
     * （2）弹出“出栈”顶端数据
     * @return
     */
    public Node poll(){
        if(stack1.peek() != null){
            in2outStack();
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Stack2Queue queue = new Stack2Queue();
        System.out.println("::::::"+queue.peek());
        queue.offer(new Node(102));

        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            queue.offer(node);
            System.out.println(":::peek:::"+queue.peek().value);

        }

        queue.offer(new Node(101));

        Node node = null;
        while ((node = queue.poll()) != null){
            System.out.println(":::poll:::"+node.value+" ");

            queue.offer(new Node(100));

            node = queue.poll();
            System.out.println(":::poll:::"+node.value+" ");
        }

    }
}
