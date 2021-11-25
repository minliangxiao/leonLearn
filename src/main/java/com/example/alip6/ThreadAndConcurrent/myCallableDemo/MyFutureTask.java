package com.example.alip6.ThreadAndConcurrent.myCallableDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义FutureTask类
 * @param <V>
 */
public class MyFutureTask<V> implements Runnable{
    private MyCallable<V> myCallable;
    private Object lock=new Object();
    private V result;

    public MyFutureTask(MyCallable<V> myCallable) {
        this.myCallable = myCallable;
    }

    @Override
    public void run() {
       // 执行线程代码
        try {
            result = myCallable.cll();
            synchronized (this.lock){
                this.lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public V get() throws InterruptedException, ExecutionException {
         synchronized (this.lock){
             this.lock.wait();
         }
       return result;
    }
 }
