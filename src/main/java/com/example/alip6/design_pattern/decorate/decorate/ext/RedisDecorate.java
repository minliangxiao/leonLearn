package com.example.alip6.design_pattern.decorate.decorate.ext;

import com.example.alip6.design_pattern.decorate.decorate.AbstractDecorate;
import com.example.alip6.design_pattern.decorate.decorate.impl.JvmComponentCache;
import com.example.alip6.design_pattern.decorate.utils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 装饰模式的增强类  二级缓存
 */
@Component
public class RedisDecorate  extends JvmComponentCache implements AbstractDecorate {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public <T> T getCacheEntiy(String key, Class<T> t, ProceedingJoinPoint joinPoint) {
        // 先查二级缓存
        T redisUser = redisUtil.getEntity(key, t);
        if (redisUser!=null) {
            return redisUser;
        }
        // 二级缓存 不存在查一级缓存
        T jvmUser = super.getCacheEntiy(key, t, joinPoint);
        if (jvmUser==null) {
            return null;
        }
        // 将内容存进二级缓存
        redisUtil.putEntity(key,jvmUser);
        return jvmUser;
    }
}
