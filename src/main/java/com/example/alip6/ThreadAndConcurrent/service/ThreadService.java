package com.example.alip6.ThreadAndConcurrent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring @Async注解实现多线程案例
 */
@RestController
public class ThreadService {
    private Logger log = LoggerFactory.getLogger(ThreadService.class);
    @Autowired
    private OrderManage orderManage;
    @GetMapping("order")
    public String getorder() throws InterruptedException {
        log.info("<1>:"+Thread.currentThread().getName());
         orderManage.asynLog();
       /* asynLog();*/
        log.info("<3>:" +Thread.currentThread().getName());
        return "this is order";
    }
    /*@Async
    void asynLog() throws InterruptedException {
        Thread.sleep(3000);
        log.info("<2>:"+Thread.currentThread().getName());
    }*/
}
