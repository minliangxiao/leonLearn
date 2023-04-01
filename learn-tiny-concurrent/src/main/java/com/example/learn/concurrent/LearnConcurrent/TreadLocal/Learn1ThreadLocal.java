package com.example.learn.concurrent.LearnConcurrent.TreadLocal;

/**
 * [这是第一个关于ThreadLocal API的方法]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/29 22:29]
 */
public class Learn1ThreadLocal {
    public static void main(String[] args) {
//        范型中的string类型表示当前线程希望换成一个string类型的变量到副本中

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("harlan");
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("nihao");
                System.out.println("子线程："+threadLocal.get());
            }
        }).start();
        System.out.println("主线程："+threadLocal.get());
    }
}
