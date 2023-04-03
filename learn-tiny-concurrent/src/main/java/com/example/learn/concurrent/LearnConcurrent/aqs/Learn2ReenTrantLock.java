package com.example.learn.concurrent.LearnConcurrent.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * [简单的回忆一下ReenTrantLock的api使用方式]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/4/1 16:41]
 */
public class Learn2ReenTrantLock {
    public static void main(String[] args) {
        // 不传参数表示当前这把可重入锁 是非公平锁，传入参数为false代表当前这把锁是公平锁
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }



    }
}
