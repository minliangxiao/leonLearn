package com.example.alip6.HashMapLearn.demo;

import com.example.alip6.HashMapLearn.bean.HashKey;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo01 {
    public static void main(String[] args) {
        HashMap<HashKey,Integer> map = new HashMap<HashKey, Integer>(1000);
        int counter = 0;
        while (true){
            HashKey key =new HashKey("hl","12432");
            map.put(key,1);
            counter++;
            if (counter%100 ==0){
                System.out.println("map Size:"+map.size());
                System.out.println("运行"+counter+"次后，可用的内存"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
            }
        }
    }
}
