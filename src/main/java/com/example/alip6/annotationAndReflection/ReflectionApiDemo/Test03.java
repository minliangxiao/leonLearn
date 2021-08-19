package com.example.alip6.annotationAndReflection.ReflectionApiDemo;

import com.example.alip6.bean.UserEntity;

import java.lang.reflect.Field;

/**
 * 关于反射操作属性的api
 */
public class Test03 {
    /*
    * getField getDeclatedField获取指定名称的属性
    * getFields 获取本类和超类的非私有属性
    * getDeclatedFields 获取本类的所以属性包括私有属性
    * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.example.alip6.bean.UserEntity");
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        /*
        * 查找属性并赋值
        * */
        Field userName = aClass.getDeclaredField("userName");
        // 修改私有属性需要把权限打开
        userName.setAccessible(true);
        userName.set(userEntity,"goupyb");
        System.out.println(userEntity.getUserName());
        Field[] fields = aClass.getFields();
        System.out.println("所有共有属性");
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println("所有属性");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
}
