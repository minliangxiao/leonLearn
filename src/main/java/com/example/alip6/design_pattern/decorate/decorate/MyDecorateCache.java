package com.example.alip6.design_pattern.decorate.decorate;

import com.example.alip6.design_pattern.decorate.decorate.ext.RedisDecorate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 装饰模式缓存机制的主控制器
 */
@Component
public class MyDecorateCache {
    @Autowired
    private RedisDecorate redisDecorate;
    public <T> T getCacheEntity(String key, Class<T> t, ProceedingJoinPoint joinPoint){
        return  redisDecorate.getCacheEntiy(key,t,joinPoint);
    }
}
