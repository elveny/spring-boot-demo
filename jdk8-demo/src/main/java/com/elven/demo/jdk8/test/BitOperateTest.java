package com.elven.demo.jdk8.test;

/**
 * Created by Administrator on 2016/10/17.
 */
public class BitOperateTest {
    public static void main(String[] args) {
        System.out.println("::::(5 & 2)::"+(5 & 2));// 0101 & 0010 = 0000 = 0
        System.out.println("::::(5 | 2)::"+(5 | 2));// 0101 | 0010 = 0111 = 7
        System.out.println("::::(5 ^ 2)::"+(5 ^ 2));// 0101 ^ 0010 = 0111 = 7
        System.out.println("::::(~5)::"+(~5));
        System.out.println("::::(5<<2)::"+(5<<2));// 0000 0101 >> 2 = 0001 0100 = 20
        System.out.println("::::(5>>2)::"+(5>>2));// 0000 0101 >> 2 = 0000 0001 = 1
        System.out.println("::::(5>>>2)::"+(5>>>2));// 0000 0101 >>> 2 = 0000 0101 >> 2 = 0000 0001 = 1
        System.out.println("::::(5>>>3)::"+(5>>>3));// 0000 0101 >>> 3 = 0000 0101 >> 3 = 0000 0000 = 0
        System.out.println("::::(-5>>>3)::"+(-5>>>3));// 1111 1111 1111 1111 1111 1111 1111 0101 >>> 3 = 0001 1111 1111 1111 1111 1111 1111 1110 =

        System.out.println("::::Integer.toBinaryString(20)::"+Integer.toBinaryString(20));
        System.out.println("::::Integer.toBinaryString(536870911)::"+Integer.toBinaryString(536870911));
        System.out.println("::::Integer.toOctalString(20)::"+Integer.toOctalString(20));
        System.out.println("::::Integer.toBinaryString(20)::"+Integer.toHexString(20));
        System.out.println("::::(~-1)::"+(~-1));


    }
}
