package com.example.alip6.ThreadAndConcurrent;

import java.util.concurrent.Callable;

/**
 * Callable案例
 */
public class ThreadCallable implements Callable<Integer> {

    /**
     * @return 当前线程执行返回结果
     * @throws Exception 异常
     */
    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程返回 1");
        return 1;
    }
}
