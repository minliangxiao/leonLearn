package com.example.alip6.ThreadAndConcurrent.myCallableDemo;

import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable =new MyCallableImpl();
        MyFutureTask myFutureTask = new  MyFutureTask(myCallable);
        new Thread(myFutureTask).start();
        Object o = myFutureTask.get();
        System.out.println(Thread.currentThread().getName()+"。"+o);
    }
}
