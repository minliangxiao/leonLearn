package com.example.learn.concurrent.LearnConcurrent.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * [简单的复习下LockSupport的简单用法]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/4/1 14:43]
 */
public class Learn1LockSupport {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+":start");
            // 使当前线程阻塞
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+":end");
        });
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 唤醒t1线程
        LockSupport.unpark(t1);
    }
}
