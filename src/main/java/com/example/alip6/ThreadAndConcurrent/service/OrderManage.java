package com.example.alip6.threadAndConcurrent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component

public class OrderManage {
    private Logger log = LoggerFactory.getLogger(ThreadService.class);
    @Async
    void asynLog()  {
        try {
            Thread.sleep(3000);
            log.info("<2>:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
