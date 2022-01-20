package com.example.alip6.design_pattern.observer;

import com.alibaba.fastjson.JSONObject;

/**
 * 观察者模式顶层接口
 */
public interface Observer {
    void sendMsg(JSONObject jsonObject);
}

