package com.example.alip6.design_pattern.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MySubject {

    /**
     * 观察者集合
     */
    private List<Observer> list =new ArrayList<>();

    /**
     * 线程池
     */
    private ExecutorService executorService;

    /**
     * 初始化线程池
     */
    public MySubject(){
        executorService= Executors.newFixedThreadPool(10);

    }


    /** 注册观察者
     * @param observer 观察者模型
     */
    public void addObserver(Observer observer){
        list.add(observer);
    }

    public void notifyObserver(JSONObject jsonObject){
        for (Observer observer : list) {

            executorService.execute(new Runnable() {
                // 单独开启线程去异步处理
                @Override
                public void run() {
                    observer.sendMsg(jsonObject);
                }
            });
        }
    }


}
