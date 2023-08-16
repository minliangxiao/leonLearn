package com.example.alip6.design_pattern.decorate.decorate.impl;

import com.example.alip6.design_pattern.decorate.decorate.ComponentCache;
import com.example.alip6.design_pattern.decorate.utils.JvmMapCacheUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 一级缓存
 */
@Component
public class JvmComponentCache implements ComponentCache {

    @Override
    public <T> T getCacheEntiy(String key, Class<T> t, ProceedingJoinPoint joinPoint) {
        // 先查询一级缓存（jvm内置）
        T jvmUser = (T) JvmMapCacheUtils.getEntity(key, t);
        if (jvmUser!=null){
            return jvmUser;
        }
        // 通过Aop 查询db
        try {
            Object proceed = joinPoint.proceed();
            JvmMapCacheUtils.putEntity(key,proceed);
            return (T) proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
