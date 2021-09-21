package com.example.alip6.ThreadAndConcurrent.ApiDemo;

/**
 * 线程优先级api
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int count = 0;
            for (;;){
                System.out.println(Thread.currentThread().getName()+","+count++);
            }
        }, "t1线程");
        Thread thread2 = new Thread(() -> {
             int count = 0;
             for (;;){
                 System.out.println(Thread.currentThread().getName()+","+count++);
             }
        }, "t2线程");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();

    }
}
