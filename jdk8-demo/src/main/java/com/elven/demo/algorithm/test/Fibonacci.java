package com.elven.demo.algorithm.test;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Fibonacci {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("start::::::"+start);
        long r = new Fibonacci().fn(100L);
        System.out.println("Fibonacci().fn(0)::::::"+r);
        long end = System.currentTimeMillis();

        System.out.println("end::::::"+end);
        System.out.println("spend::::::"+(end  -  start));
    }

    public long fn(long n){
        long result = 0L;

        if(n <= 0){
            result = 0L;
        }
        else if(n == 1 || n==2){
            result = 1L;
        }
        else{
            result = fn(n-1)+fn(n-2);
        }

        return result;
    }


}
