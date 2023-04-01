package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.mylogframe;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
@Component
public class LogManage {
    private BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();

    private LogThread logThread;

    public LogManage() {
        logThread = new LogThread();
        logThread.start();
    }

    public void  info(String info){
        blockingDeque.offer(info);
    }

    /**
     * 这个线程类还可以优化 可以结合线程池做优化
     */
    class LogThread extends Thread{
        @Override
        public void run() {
            while (true){
                String info = blockingDeque.poll();
                // 按照道理这里是因该将日志文件存在 磁盘中或者数据库中 但是这里为了简化就不去做那一步了
                if (!StringUtils.isEmpty(info)) {
                    System.out.println(info);
                }
            }
        }
    }
}
