package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.ApiDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁的api
 * lock锁的基本使用方式
 */
public class LockApi01  implements  Runnable{
    private Lock lock = new ReentrantLock();
    private static int count = 100;


    public void cal(){
        try {
            lock.lock();
            if (count > 1){
                count--;
                System.out.println(Thread.currentThread().getName()+","+count);
            }
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cal();
        }
    }

    public static void main(String[] args) {
        LockApi01 lockApi01 = new LockApi01();
        Thread thread = new Thread(lockApi01);
        Thread thread1 = new Thread(lockApi01);
        thread.start();
        thread1.start();
    }
}
