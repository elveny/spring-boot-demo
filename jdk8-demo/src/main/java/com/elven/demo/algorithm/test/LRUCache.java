package com.elven.demo.algorithm.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2016/10/25.
 */
public class LRUCache {
    public static void main(String[] args) {
        inheritanceTest1();
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
        inheritanceTest2();
    }

    public static void inheritanceTest1(){
        int cacheSize = 10;
        int capacity = (int) Math.ceil(cacheSize / 0.75f)+1;
        System.out.println("::::capacity::"+capacity);
        Map<String, String> map = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > cacheSize;
            }
        };

        LinkedHashMap mm = new LinkedHashMap();

        for (int i = 0; i < 100; i++) {
            map.put(""+i, ""+i);
            if(i > 0){

                int n = new Random().nextInt(i);
                System.out.println("::::n::"+n);
                map.put(""+n, ""+n);
            }
            System.out.println(map);
        }
    }

    public static void inheritanceTest2(){
        LRUCache1<String, String> map = new LRUCache1<String, String>(10);

        for (int i = 0; i < 100; i++) {
            map.put(""+i, ""+i);
            if(i > 0){

                int n = new Random().nextInt(i);
                System.out.println("::::n::"+n);
                map.put(""+n, ""+n);
            }
            System.out.println(map);
        }
    }
}

class LRUCache1<K, V> extends LinkedHashMap<K, V>{
    private final int MAX_CACHE_SIZE;

    public LRUCache1(int max_cache_size) {
        super((int) Math.ceil(max_cache_size / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = max_cache_size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }
}
