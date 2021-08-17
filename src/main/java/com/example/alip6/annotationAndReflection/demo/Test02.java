package com.example.alip6.annotationAndReflection.demo;

import com.example.alip6.bean.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射机制创建对象api
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.example.alip6.bean.UserEntity");
        /*
        * 调用无参构造创建对象
        * */
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        System.out.println(userEntity);

        /*
        * 调用有参构造对象
        * */
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, Integer.class);
        UserEntity userEntity1 = (UserEntity) declaredConstructor.newInstance("gowpyb",21);
        System.out.println(userEntity1);
    }
}
