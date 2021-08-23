package com.example.alip6.annotationAndReflection.aop;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 限流的aop类
 * 结合guava的RateLimiter做限流
 */
@Aspect
@Component
public class CurrentLimitAop {
    private ConcurrentHashMap<String, RateLimiter> rateLimiters =   new ConcurrentHashMap();

    @Around(value = "@annotation(com.example.alip6.annotationAndReflection.annotation.Limiter)")
    public Object around(ProceedingJoinPoint joinPoint){

        return null;
    }
}
