package com.example.alip6.annotationAndReflection.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GrowYb {
    String name() default "";

    double token() default 1;
}
