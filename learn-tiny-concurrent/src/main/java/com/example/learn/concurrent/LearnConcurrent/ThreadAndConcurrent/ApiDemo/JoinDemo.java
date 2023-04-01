package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.ApiDemo;

/**
 * 线程同步方法join的demo
 * 创建三个线程，保持t1,t2,t3执行
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"  1");
        },"t1");
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  2");
        },"t2");
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  3");
            },"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
