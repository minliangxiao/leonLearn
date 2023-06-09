package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
    /*测试*/
    @GetMapping("test")

    public String test(HttpServletRequest request){
        Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        return "";
    }

}
