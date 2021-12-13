package com.example.alip6.HashMapLearn.demo;

import java.util.HashMap;

public class Demo02 {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        Object put = map.put("a", "a");
        System.out.println(put);
        Object put1 = map.put("a", "b");
        System.out.println(put1);

    }
}
