package com.example.alip6.annotationAndReflection.ReflectionApiDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射机制越过泛型机制
 */
public class Test05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("gorwyb");
        Class<? extends ArrayList> aClass = arrayList.getClass();
        Method addMethod = aClass.getDeclaredMethod("add", Object.class);
        addMethod.invoke(arrayList,1);
        System.out.println(arrayList);
        /*
        *  反射机制越过泛型可能出现一个情况，就是如果用lambda表达式遍历集合的时候可能出现类型转换异常
        * */
        arrayList.forEach(t->{
            System.out.println(t);
        });
    }
}
