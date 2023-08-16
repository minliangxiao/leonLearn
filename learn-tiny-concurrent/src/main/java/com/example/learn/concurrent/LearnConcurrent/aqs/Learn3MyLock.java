package com.example.learn.concurrent.LearnConcurrent.aqs;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * [这个案例是手写一个简单的Lock锁，以理解Lock的实现机制]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/4/1 16:36]
 */
public class Learn3MyLock {

    /**
     * 锁的状态 0表示无线程获取到锁，1表示已经有线程获取到锁了
     */
    private AtomicInteger lockState = new AtomicInteger(0);

    /**
     * 用以记录当前线程
     */
    private Thread getLockThread = null;

    private ConcurrentLinkedDeque<Thread> concurrentLinkedDeque = new ConcurrentLinkedDeque<Thread>();

    /**
     * 获取锁
     * @return 是否成功标志位
     */
    public void lock(){
           acquire();
//        return false;
    }

    public boolean acquire(){
        // 用这个死循环控制
        while (true){
            if (compareAndSet(0,1)){
                // 获取锁成功  记录当前线程
                getLockThread = Thread.currentThread();
                return  true;
            }
            // 获取当前线程失败 阻塞当前线程并将当前线程放入阻塞队列
            Thread thread = Thread.currentThread();
            concurrentLinkedDeque.add(thread);
            LockSupport.park();
        }

    }

    public boolean compareAndSet(int expect, int update) {
        return  lockState.compareAndSet(expect,update);
    }

    /**
     * 释放锁
     * @return 是否成功标志位
     */
    public boolean unLock(){
        // 判断当前是否为当前线程  因为必须要当前获取到锁的线程才能释放掉锁
        if (getLockThread == null){
            return false;
        }
        if (getLockThread == Thread.currentThread()){
            // 将cas原子类的状态改成无锁
            boolean result = compareAndSet(1, 0);
            if (result){
                // 唤醒阻塞线程(这里只是实现了公平锁的唤醒，如果是非公平锁，需要遍历循环concurrentLinkedDeque队列中的所有元素然后唤醒，让所有线程去竞争)
                Thread first = concurrentLinkedDeque.getFirst();
                LockSupport.unpark(first);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Learn3MyLock lock = new Learn3MyLock();
        lock.lock();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+":start");
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":end");
        }).start();
        Thread.sleep(1000);
        lock.unLock();
        
    }
}
