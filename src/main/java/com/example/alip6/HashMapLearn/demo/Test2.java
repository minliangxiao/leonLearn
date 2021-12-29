package com.example.alip6.HashMapLearn.demo;

public class Test2 {
    public static void main(String[] args) {
        long zuoStart = System.nanoTime();
        int i = 16 << 1;
        long zouEnd = System.nanoTime();
        System.out.println(zouEnd-zuoStart);

        long chenStart = System.nanoTime();
        int i1 = 16 * 2;
        long end = System.nanoTime();
        System.out.println(end-chenStart);
    }
}
