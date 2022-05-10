package com.learn.test;

import org.springframework.scheduling.annotation.Async;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ForkJoinPool;

public class Test {

    public static BlockingDeque<Map<String,Object>> mapBlockingDeque;


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
//        newThread newThread = new newThread();
        new Thread(new newThread()).start();
        new Thread(new newThread()).start();
        new Thread(new newThread()).start();
        new Thread(new newThread()).start();
        new Thread(new newThread()).start();

//        initDeque(mapBlockingDeque);
        forkJoinPool.submit(()->{
            try {
                Map<String, Object> take = mapBlockingDeque.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    private static void initDeque(BlockingDeque<Map<String, Object>> mapBlockingDeque) throws InterruptedException {
        Map<String, Object> stringObjectMap = new HashMap<>();
//        Integer.MAX_VALUE
        stringObjectMap.put(Thread.currentThread().getName(), new Object());
        mapBlockingDeque.put(stringObjectMap);

    }


    static class newThread implements Runnable{

        @Override
        public void run() {
            try {
                initDeque(mapBlockingDeque);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
