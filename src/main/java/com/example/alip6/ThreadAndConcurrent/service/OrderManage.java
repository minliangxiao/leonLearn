package com.example.alip6.threadAndConcurrent.service;

import com.example.alip6.threadAndConcurrent.MyAsyncDemo.annotation.MyAsync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component

public class OrderManage {
    private Logger log = LoggerFactory.getLogger(ThreadService.class);
    @MyAsync
    void asynLog()  {
        try {
            log.info("目标方法开始执行正在阻塞3秒时间");
            Thread.sleep(3000);
            log.info("<2>:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
