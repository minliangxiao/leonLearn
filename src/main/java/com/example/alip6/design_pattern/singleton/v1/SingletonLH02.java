package com.example.alip6.design_pattern.singleton.v1;

/**
 *  双重检验锁实现懒汉式线程安全
 */
public class SingletonLH02 {
    private SingletonLH02() {

    }

    private static SingletonLH02 singletonLH01= null;

    public static SingletonLH02 getInstance(){

        if (singletonLH01 == null){
            synchronized (SingletonLH02.class){
                // 高并发环境下这个判断是很有必要的
                if (singletonLH01 == null){
                    singletonLH01 = new SingletonLH02();
                }
            }
        }
        return singletonLH01;
    }
}
