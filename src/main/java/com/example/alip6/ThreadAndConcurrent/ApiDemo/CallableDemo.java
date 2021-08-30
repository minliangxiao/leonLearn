package com.example.alip6.ThreadAndConcurrent.ApiDemo;

import com.example.alip6.ThreadAndConcurrent.ThreadCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口使用api
 * Callable使主线程阻塞等待子线程的返回
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(threadCallable);
        new Thread(integerFutureTask).start();
        Integer result = integerFutureTask.get();
        System.out.println(Thread.currentThread().getName()+","+result);
    }
}
