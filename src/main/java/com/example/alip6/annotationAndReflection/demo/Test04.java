package com.example.alip6.annotationAndReflection.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射操作方法api
 */
public class Test04 {
    /*
    *getMethod getDeclatedMethod获取指定名称的属性
    * getMethods 获取本类和超类的非私有属性
    * getDeclatedMethods 获取本类的所以属性包括私有属性
    * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.example.alip6.bean.UserEntity");
        Object o = aClass.newInstance();
        // 获取所有的本类方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        // 获取所有本类和父类的所有非私有的方法
        Method[] methods = aClass.getMethods();
        Method sum = aClass.getDeclaredMethod("sum", Integer.class, Integer.class);
        sum.setAccessible(true);
        // .invoke() 方法执行反射获取到的方法
        Object invoke = sum.invoke(o, 12, 15);
        System.out.println(invoke);

    }
}
