package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.mylogframe;

import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
//        LinkedBlockingDeque是一个无界的队列  可以无限的存东西
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();
        // 向队列中存储类型
        deque.offer("log1");
        deque.offer("log2");

        //取队列中的东西
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }
}
