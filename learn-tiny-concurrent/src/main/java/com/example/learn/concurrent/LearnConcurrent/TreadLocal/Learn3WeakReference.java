package com.example.learn.concurrent.LearnConcurrent.TreadLocal;

import java.lang.ref.WeakReference;

/**
 * [弱引用案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/30 22:51]
 */
public class Learn3WeakReference {
    public static void main(String[] args) {
        // o1是强引用
        Object o1 = new Object();
        // softReference这个时候就是软引用的01
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println("o1:" + o1);
        System.out.println("弱引用对象:" + weakReference.get());
        o1 = null;
        System.gc();
        System.out.println("----------------------------");
        System.out.println("o1:" + o1);
        // 弱引用通知gc后就会被清除
        System.out.println("弱引用对象:" + weakReference.get());


    }
}
