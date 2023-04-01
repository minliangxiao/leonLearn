package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.MyAsyncDemo.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAsync {
}
