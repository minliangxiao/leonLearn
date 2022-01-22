package com.example.alip6.design_pattern.singleton.v1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  静态内部类实现单例模式
 */
public class SingletonLH03 {
    private SingletonLH03() {

    }

    /**
     * 内部类在被调用的时候才会初始化
     */
    private static class SingletonUtils{
        private static final SingletonLH03 singletonLH01 = new SingletonLH03();
    }

    public static SingletonLH03 getInstance(){
        return SingletonUtils.singletonLH01;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<SingletonLH03> declaredConstructor = SingletonLH03.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonLH03 singletonLH03 = declaredConstructor.newInstance();

    }
}
