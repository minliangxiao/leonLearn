package com.example.alip6.design_pattern.singleton.v1;

/**
 *  线程不安全的懒汉式单例
 */
public class SingletonLH01 {
    private SingletonLH01() {
    }

    private static SingletonLH01 singletonLH01= null;

    public static  SingletonLH01 getInstance(){
        if (singletonLH01 == null){
            singletonLH01 = new SingletonLH01();
        }
        return singletonLH01;
    }
}
