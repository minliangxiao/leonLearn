package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.ApiDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的简单api
 */
public class ThreadExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()+"这个是线程池创建的子线程"));
    }
}
