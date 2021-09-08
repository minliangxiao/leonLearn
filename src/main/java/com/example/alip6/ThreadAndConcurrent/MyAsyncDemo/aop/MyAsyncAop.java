package com.example.alip6.threadAndConcurrent.MyAsyncDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAsyncAop {
    private Logger log = LoggerFactory.getLogger(MyAsyncAop.class);

    /** 环绕通知
     * @param joinPoint 截面
     * @return
     */
    @Around(value = "@annotation(com.example.alip6.threadAndConcurrent.MyAsyncDemo.annotation.MyAsync)")
    public void around(ProceedingJoinPoint joinPoint){
        // 走环绕通知
        try{
            log.info(">环绕通知开始执行<");
            new Thread(() -> {
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }).start();
            log.info(">环绕通知结束执行<");

        }catch (Throwable throwable) {
            throwable.printStackTrace();

        }
    }
}
