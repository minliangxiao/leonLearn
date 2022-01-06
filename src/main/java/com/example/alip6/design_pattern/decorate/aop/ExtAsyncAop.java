package com.example.alip6.design_pattern.decorate.aop;

import com.example.alip6.design_pattern.decorate.decorate.MyDecorateCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义注解aop类
 */
@Aspect
@Component
public class ExtAsyncAop {
    @Autowired
    private MyDecorateCache cacheManager;
    @Around(value = "@annotation(com.example.alip6.design_pattern.decorate.aop.ExtMyCache)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取到目标对象
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        // 获取到目标方法
        Method method = methodSignature.getMethod();
        // 拼接缓存中的key  目标方法名字+目标方法参数类型+参数内容
        String kay = method.getName() + Arrays.toString(method.getParameterTypes())+Arrays.toString(joinPoint.getArgs());
        // 将所需要的信息传递到二级缓存机制中
        Object result = cacheManager.getCacheEntity(kay,method.getReturnType(),joinPoint);

        return result;
    }
}
