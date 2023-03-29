package com.example.learn.concurrent.LearnConcurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [这是关于cas理论的一些学习]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/26 10:31]
 */
public class Learn1Cas {
    public static void main(String[] args) {
        /**
         * 场景描述：
         * V=共享变量=0
         * 线程1 -- E=每个线程中都会缓存副本v的值 ----旧的预期值==E=0 N=新的预期值也就是需要修改的值=1
         * 线程2 -- E=每个线程中都会缓存副本v的值 ----旧的预期值==E=0 N=新的预期值也就是需要修改的值=2
         * */

        // AtomicInteger 是jdk提供的原子类  底层是一个c语言写的Unsafe类
        AtomicInteger atomicInteger = new AtomicInteger(0);
        boolean b = atomicInteger.compareAndSet(0, 1);
        boolean c = atomicInteger.compareAndSet(1, 2);
        System.out.println("线程一修改："+b+"....."+atomicInteger.get());
        System.out.println("线程二修改："+c+"....."+atomicInteger.get());
    }
}
