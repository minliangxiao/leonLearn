package com.example.alip6.ThreadAndConcurrent.ApiDemo;

/**
 * yield() 释放当前cpu执行权的api
 */
public class YeildApi extends Thread{
    public YeildApi(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i == 30){
                System.out.println(Thread.currentThread().getName()+",释放cpu执行权");
                yield();
            }
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }

    public static void main(String[] args) {
        new YeildApi("线程1").start();
        new YeildApi("线程2").start();
    }
}
