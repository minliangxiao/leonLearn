package com.example.alip6.annotationAndReflection.aop;

import com.example.alip6.annotationAndReflection.annotation.Limiter;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
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
        // 走环绕通知
        try{
            // 获取拦截方法
            Signature sig = joinPoint.getSignature();
            // 获取拦截的方法名（反射获取）
            MethodSignature methodSignature = (MethodSignature) sig;
            Limiter limiter = methodSignature.getMethod().getDeclaredAnnotation(Limiter.class);
            // 获取到该注解的name
            String name = limiter.name();
            // 获取到该注解的token
            double token = limiter.token();
            RateLimiter rateLimiter = rateLimiters.get(name);
            if (rateLimiter == null){
                rateLimiter = RateLimiter.create(token);
                rateLimiters.put(name,rateLimiter);
            }
            /*
            * 调用guava的方法执行限流相关操作
            * */
            boolean result = rateLimiter.tryAcquire();
            if (!result){
                return "当前访问人数过多，请稍后重试";
            }
            // 执行目标方法
            Object proceed = joinPoint.proceed();
            return proceed;
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            return "系统错误";
        }

    }
}
