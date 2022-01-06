package com.example.alip6.design_pattern.decorate.decorate;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 装饰的共同规范接口
 */
public interface ComponentCache {

    <T> T getCacheEntiy(String key, Class<T> t, ProceedingJoinPoint joinPoint);

}
