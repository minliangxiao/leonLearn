package com.example.alip6.threadAndConcurrent.ApiDemo;

/**
 * 关于join底层notify()在jvm hostport层面实现的验证
 */
public class AboutWaitAndNotify {
    private Object lock = new Object();
    public static void main(String[] args) {
        AboutWaitAndNotify aboutWaitAndNotify = new AboutWaitAndNotify();
        Thread print = aboutWaitAndNotify.print();
        print.start();
        try {
            Thread.sleep(3000);
            // 中断线程 中断线程后会发现 线程会执行wait之后的内容，那是因为jvm 在中断线程时会先执行优化的notify中的内容即先唤醒等待线程执行。
            print.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public Thread print(){
        Thread thread = new Thread(() -> {
                synchronized (lock){
                    System.out.println("1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2");
                }
        });
        return thread;
    }
}
