package com.example.alip6.annotationAndReflection.demo;

import com.example.alip6.bean.UserEntity;

/**
 * 反射机制api练习
 */
public class Test01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        反射机制就是动态的获取class 信息内容  类的名称
        /*
        * 获取class 的方式
        * 1. 类名.class
        * 2. Class.forName("全路径")
        * 3. new 出一个对象然后在用 对象.getClass()获取到class对象
        * */
        Class  userEntityClass = UserEntity.class;
        // .newInstance() 默认调用的是无参构造方法
        UserEntity o = (UserEntity) userEntityClass.newInstance();
        System.out.println(o);

        Class<?> aClass = Class.forName("com.example.alip6.bean.UserEntity");
        // 由于UserEntity.class 只有一份 所以userEntityClass == aClass成立
        System.out.println(userEntityClass == aClass);

        UserEntity userEntity = new UserEntity();
        Class<? extends UserEntity> aClass1 = userEntity.getClass();
        System.out.println(aClass1 == userEntityClass);

    }
}
