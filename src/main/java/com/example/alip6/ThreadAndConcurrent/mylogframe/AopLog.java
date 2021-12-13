package com.example.alip6.ThreadAndConcurrent.mylogframe;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class AopLog {
    private static final String START_TIME = "request-start";
    private SimpleDateFormat sdf4  = new SimpleDateFormat("yyyy年MM月dd日");
    @Autowired
    private LogManage logManage;


    /**
     * 切入点
     */
    @Pointcut("execution(public * com.example.alip6.ThreadAndConcurrent.mylogframe.*Service.*(..))")
    public void log(){

    }

    /** 前置通知  参数为切入点
     * @param joinPoint
     */
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        logManage.info("【请求 时间】："+sdf4.format(new Date()));
        logManage.info("【请求 URL】："+request.getRequestURL());
        logManage.info("【请求 IP】："+request.getRemoteAddr());
        logManage.info("【请求 Class】："+joinPoint.getSignature().getDeclaringTypeName());
        logManage.info("【请求 方法名Method】："+joinPoint.getSignature().getName());
        logManage.info("【请求 参数Args】："+ JSON.toJSONString(joinPoint.getArgs()));

    }
}
