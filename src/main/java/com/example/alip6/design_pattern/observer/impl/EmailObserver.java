package com.example.alip6.design_pattern.observer.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.alip6.design_pattern.observer.Observer;
import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements Observer {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        System.out.println(Thread.currentThread().getName()+":使用观察者模式发送邮件");
    }
}
