package com.example.alip6.HashMapLearn.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用LinkedHashMap来手写个LRU淘汰策略
 */
public class MyLRU<K,V> extends LinkedHashMap {
    private int capacity;

    public MyLRU(int capacity) {
        // 第三个参数 accessOrder为ture时 LinkedHashMap 按照访问顺序进行排序
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    /**
     * 淘汰策略当当前链表容量存满了后 淘汰掉链表头部元素也就是最少使用的元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        MyLRU<String,String> myLRU = new MyLRU<>(4);
        myLRU.put("a","a");
        myLRU.put("b","b");
        myLRU.put("c","c");
        myLRU.put("a","a");
        myLRU.put("d","d");
        myLRU.put("e","e");
        // 会发现会淘汰掉 b
        myLRU.forEach((k,v)->{
            System.out.println("k:"+k+", v:"+v);
        });
    }
}
