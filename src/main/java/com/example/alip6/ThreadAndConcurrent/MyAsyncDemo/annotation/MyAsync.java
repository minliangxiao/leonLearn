package com.example.alip6.threadAndConcurrent.MyAsyncDemo.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAsync {
}
