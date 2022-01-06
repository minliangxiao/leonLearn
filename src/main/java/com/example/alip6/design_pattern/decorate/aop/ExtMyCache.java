package com.example.alip6.design_pattern.decorate.aop;

import java.lang.annotation.*;

/**
 * 自定义缓存注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtMyCache {

}
