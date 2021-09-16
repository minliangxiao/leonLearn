package com.example.alip6.threadAndConcurrent.ApiDemo;

/**
 * 用户线程变成守护线程
 */
public class UserThreadToProtecteThreadApi {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName()+":子线程还在运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "我是子线程");
        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName()+":主线程结束");
    }
}
