package com.example.alip6.annotationAndReflection.demo;

/**
 * 反射操作方法api
 */
public class Test04 {
    /*
    *getMethod getDeclatedMethod获取指定名称的属性
    * getMethods 获取本类和超类的非私有属性
    * getDeclatedMethods 获取本类的所以属性包括私有属性
    * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.example.alip6.bean.UserEntity");
        Object o = aClass.newInstance();

    }
}
