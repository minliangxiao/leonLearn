package com.example.alip6.ThreadAndConcurrent.ApiDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁的通信机制 await 和 signal
 */
public class LockApi02 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void  cal(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"<1>");
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+"<2>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
    public void signal(){
        try {
            lock.lock();
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockApi02 lockApi02 = new LockApi02();
        lockApi02.cal();
        Thread.sleep(3000);
        lockApi02.signal();
    }
}
