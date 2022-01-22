package com.example.alip6.design_pattern.facede.service;

import org.springframework.stereotype.Component;

@Component
public class MsgService {
    public void sendMsg(){
        System.out.println("调用消息服务平台");
    }
}
