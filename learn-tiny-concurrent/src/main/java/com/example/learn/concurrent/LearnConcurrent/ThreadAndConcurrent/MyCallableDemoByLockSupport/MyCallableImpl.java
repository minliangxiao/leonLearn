package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.MyCallableDemoByLockSupport;

import com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.myCallableDemo.MyCallable;

public class MyCallableImpl implements MyCallable<Integer> {
    @Override
    public Integer cll() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"结束执行");
        return 1;
    }
}
