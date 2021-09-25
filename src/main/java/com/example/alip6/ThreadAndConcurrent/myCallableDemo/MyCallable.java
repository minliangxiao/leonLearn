package com.example.alip6.ThreadAndConcurrent.myCallableDemo;

/**
 * 自定义Callable接口
 */
public interface MyCallable <V>{
    /** 等待当前线程返回结果
     * @return
     * @throws Exception
     */
    V cll() throws Exception;
}
