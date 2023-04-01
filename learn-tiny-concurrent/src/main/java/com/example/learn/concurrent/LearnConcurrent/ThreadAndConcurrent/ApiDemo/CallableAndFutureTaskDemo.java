package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.ApiDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable 和 FutureTask 原理代码
 */
public class CallableAndFutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable =new ThreadCallable();
        FutureTask<Integer> integerFutureTask =new FutureTask<Integer>(threadCallable);
        new Thread(integerFutureTask).start();
        // 主线程等待子线程的返回结果
        Integer integer = integerFutureTask.get();
        System.out.println(Thread.currentThread().getName());
    }
}

class ThreadCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"结束执行");
        return 1;
    }
}
