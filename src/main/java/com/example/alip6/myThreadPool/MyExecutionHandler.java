package com.example.alip6.myThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * [自定义线程池拒绝策略案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/25 14:42]
 */
public class MyExecutionHandler implements ThreadFactory, RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.getClass()+"这里写自定义拒绝策略逻辑");
        r.run();
    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
