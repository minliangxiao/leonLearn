package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.MyCallableDemoByLockSupport;

import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableImpl myCallable = new MyCallableImpl();
        MyFutureTaskByLockSupport<Integer> integerMyFutureTaskByLockSupport = new MyFutureTaskByLockSupport<>(myCallable);
        new Thread(integerMyFutureTaskByLockSupport).start();
        // 因为是主线程调用的 .get()方法，所以get()方法中Thread.currentThread()获取到的线程是main
        Integer integer = integerMyFutureTaskByLockSupport.get();
        System.out.println(integer);
    }
}
