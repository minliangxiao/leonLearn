package com.example.alip6.threadAndConcurrent.ApiDemo;

/**
 * synchronized修饰实例方法
 */
public class SynchronizedDemo2 implements Runnable {
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            if (count > 1) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clc();
            }

        }
    }

    private synchronized void clc() {
        count--;
        System.out.println(Thread.currentThread().getName() + "," + count);
    }


    public static void main(String[] args) {
        SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        SynchronizedDemo1 synchronizedDemo11 = new SynchronizedDemo1();
        new Thread(synchronizedDemo1).start();
        new Thread(synchronizedDemo1).start();
    }
}
