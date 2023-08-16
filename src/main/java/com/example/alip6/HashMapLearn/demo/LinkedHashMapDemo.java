package com.example.alip6.HashMapLearn.demo;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("a","a");
        linkedHashMap.put("b","b");
        linkedHashMap.put("c","c");
        linkedHashMap.put("d","d");
        linkedHashMap.put("a","aaa");
        ConcurrentHashMap map = new ConcurrentHashMap();
        linkedHashMap.forEach((k,v)->{
            System.out.println("k:"+k+", v:"+v);
        });
    }
}
