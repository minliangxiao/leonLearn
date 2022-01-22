package com.example.alip6.design_pattern.singleton.v1;

/**
 * 饿汉模式实现单例
 */
public class SingletonEH01 {

    /*
    *  饿汉模式优点是先天线程安全，这个安全是指创建时的线程安全并不是是指使用时的线程安全  因为在出事画的时候就创建了这个对象了
    * 缺点：如果使用过多的饿汉模式那么项目会非常的慢原因是实例放在方法区会占用很多内存而且，初始化的时候就创建好了实例如果用户不使用的话会造成很大的浪费
    * */
    private static  SingletonEH01 singletonEH01 = new SingletonEH01();

    private SingletonEH01() {

    }

    public static SingletonEH01 getInstance(){
        return singletonEH01;
    }
}
