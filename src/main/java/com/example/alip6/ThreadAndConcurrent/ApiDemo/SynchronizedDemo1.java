package com.example.alip6.threadAndConcurrent.ApiDemo;

/**
 * synchronized 修饰代码块
 */
public class SynchronizedDemo1 implements Runnable {
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            clc();
        }
    }

    private void clc() {
        if (count > 1) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                /*
                this 是指当前对象的对象锁，synchronized修饰代码块的时候必须确保this对象传入的是同一个对象
                * */
                count--;
                System.out.println(Thread.currentThread().getName() + "," + count);
            }
        }

    }

    public static void main(String[] args) {
        SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        SynchronizedDemo1 synchronizedDemo11 = new SynchronizedDemo1();
        new Thread(synchronizedDemo1).start();
        new Thread(synchronizedDemo1).start();
    }

}
