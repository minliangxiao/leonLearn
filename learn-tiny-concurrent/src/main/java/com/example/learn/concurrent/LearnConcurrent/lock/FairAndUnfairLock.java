package com.example.learn.concurrent.LearnConcurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * [公平锁与非公平锁案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/25 16:28]
 */
public class FairAndUnfairLock {
    /*
    * 这个列子通过观察finalI的打印顺序来观察 非公平锁和公平锁之间的区别
    * */
    public static void main(String[] args) {
        // false代表非公平锁 true代表公平锁
        ReentrantLock reentrantLock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    // 获取锁
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName()+">>>>i:"+finalI);
                }catch (Exception e){

                }finally {
                    // 释放锁
                    reentrantLock.unlock();
                }

            }).start();
        }

    }

}
