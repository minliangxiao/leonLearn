package com.example.learn.concurrent.LearnConcurrent.cas;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * [利用cas实现乐观锁案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/26 11:02]
 */
public class Learn2AtomicTryLock {

    private AtomicLong cas =  new AtomicLong(0);

    private Thread lockCurrentThread;


    /*
     * 锁状态：
     * 0 --- 代表没有人获取到锁
     * 1 --- 代表已经有人获取到锁
     * 获取成功 cas 0 变为1 cas = true
     * 获取失败 cas =false
     * */

    /**
     * 获取锁
     * @return true成功 false失败
     */
    public  boolean tryLock(){
        // 为了减少cpu资源飙升的问题，这里乐观锁的自旋次数设置为100次
        for (int i = 0; i < 100; i++) {
            if (cas.compareAndSet(0, 1)) {
                lockCurrentThread = Thread.currentThread();
                return true;
            }
        }
        return false;
    }


    /**
     * 释放锁
     * @return true成功 false失败
     */
    public boolean unLock(){
        // 锁必须由当前线程释放
        if (lockCurrentThread != Thread.currentThread()){
            return false;
        }
        return cas.compareAndSet(1,0);
    }

    public static void main(String[] args) {
        Learn2AtomicTryLock atomicTryLock = new Learn2AtomicTryLock();

        IntStream.range(1,10).forEach(i->new Thread(() -> {
            try {
                boolean result = atomicTryLock.tryLock();
                if (result){
                    atomicTryLock.lockCurrentThread = Thread.currentThread();
                    System.out.println(Thread.currentThread().getName()+"获取锁成功");

                }else {
                    System.out.println(Thread.currentThread().getName()+"获取锁失败");
                }
            }catch (Exception e){

            }finally {
                if (atomicTryLock!= null) {
                    atomicTryLock.unLock();
                }
            }
        }).start());
    }



}
