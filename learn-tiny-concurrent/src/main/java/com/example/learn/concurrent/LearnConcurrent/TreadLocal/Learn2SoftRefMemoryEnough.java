package com.example.learn.concurrent.LearnConcurrent.TreadLocal;

import java.lang.ref.SoftReference;

/**
 * [软引用案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/30 22:51]
 */
public class Learn2SoftRefMemoryEnough {
    public static void main(String[] args) {
        // o1是强引用
        Object o1 = new Object();
        // softReference这个时候就是软引用的01
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println("o1:"+o1);
        System.out.println("软引用对象:"+softReference.get());
        o1 = null;
        try {
            // 申请一块内存 需要提前将jvm内存设置为-Xms5m -Xmx5m -XX:+PrintGCDetails 5M
            byte[] bytes = new byte[30*1024*1024];
        }catch (Throwable ex){

        }finally {
            System.out.println("----------------------------");
            System.out.println("o1:"+o1);
            // 这个时候软引用对象应该就被清除了
            System.out.println("软引用对象:"+softReference.get());
        }


    }
}
