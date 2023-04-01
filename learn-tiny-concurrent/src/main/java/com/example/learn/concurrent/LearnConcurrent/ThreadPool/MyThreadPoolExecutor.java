package com.example.learn.concurrent.LearnConcurrent.ThreadPool;

import java.util.concurrent.*;

/**
 * [自定义一个线程池工具类，]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/25 14:19]
 */
public class MyThreadPoolExecutor {
    public static ExecutorService newFixedThreadPool(int corePoolSize,int maximumPoolSize,int blockingQueue){
        /**
         * 主要看拒绝策略，和缓存队列。
         * ThreadPoolExecutor 提供了4种拒绝策略(默认是AbortPolicy()丢弃任务) 和一种自定义拒绝测试
         * 自定义拒绝策略需要实现RejectedExecutionHandler接口
         * */
        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,60L,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(blockingQueue), (RejectedExecutionHandler) new MyExecutionHandler());
    }

    public static void main(String[] args) {
        /*
        * 1 首先两个核心线程数先执行任务
        * 2 核心线程数满了后，再将剩下的任务缓存到队列中。
        * 3 队列满了后，最大线程数没满，创建 最大线程数-核心线程数 个线程然后继续接任务。
        * 4 最大线程数-核心线程数满了后，触发拒绝策略。
        *
        * */
        ExecutorService executorService = MyThreadPoolExecutor.newFixedThreadPool(2, 4, 5);
        for (int i = 0; i <= 10; i++) {
            int finalI = i;
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()+","+finalI));
        }

    }
}
