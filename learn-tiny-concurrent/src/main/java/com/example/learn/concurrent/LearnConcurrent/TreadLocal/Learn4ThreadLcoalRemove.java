package com.example.learn.concurrent.LearnConcurrent.TreadLocal;

/**
 * [这是ThreadLocal避免内存泄漏的一些案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/3/30 22:51]
 */
public class Learn4ThreadLcoalRemove {
    public static void main(String[] args) {

        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("harlan");
        // 当前ThreadLcoalMap中的key值与ThreadLocal断开连接
        stringThreadLocal.remove();
        // 这种操作这回断掉当前stringThreadLocal对象与堆内存中的ThreadLocal对象的连接
        stringThreadLocal = null;
        Thread thread = Thread.currentThread();
        System.out.println(thread);


    }
}
