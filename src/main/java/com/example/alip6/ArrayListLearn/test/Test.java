package com.example.alip6.ArrayListLearn.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            System.out.println(1&i);
        }
        HashSet<String> set = new HashSet<>();
        set.add("set");

        LinkedList<String> link = new LinkedList<>();
        link.add("link");


    }
}
