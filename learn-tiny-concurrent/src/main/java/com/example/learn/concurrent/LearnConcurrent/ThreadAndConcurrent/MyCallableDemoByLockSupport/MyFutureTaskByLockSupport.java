package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.MyCallableDemoByLockSupport;

import com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.myCallableDemo.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义通过LockSupport的Api实现 FutureTask类
 * @param <V>
 */
public class MyFutureTaskByLockSupport<V> implements Runnable{
    private MyCallable<V> myCallable;
    private Object lock=new Object();
    private V result;
    private Thread currentThread;

    public MyFutureTaskByLockSupport(MyCallable<V> myCallable) {
        this.myCallable = myCallable;
    }

    @Override
    public void run() {
       // 执行线程代码
        try {
            result = myCallable.cll();
           // 如果当前线程不为空  唤醒当前线程。
            if (currentThread != null) {
                LockSupport.unpark(currentThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public V get() throws InterruptedException, ExecutionException {
        currentThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName());
        LockSupport.park();
       return result;
    }
 }
