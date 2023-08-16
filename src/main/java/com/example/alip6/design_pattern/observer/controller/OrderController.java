package com.example.alip6.design_pattern.observer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.alip6.design_pattern.observer.MySubject;
import com.example.alip6.design_pattern.observer.entiy.UserMessageEntiy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private MySubject mySubject;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /** Subject + Observer 实现的观察者模式  方便扩展
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms",1818118111);
        jsonObject.put("email","1781781781@qq.com");
        mySubject.notifyObserver(jsonObject);
        return "success";
    }

    /**
     * 基于spring回调机制实现的观察者模型  这样做有一个缺点就是默认是同步执行  如果要异步执行需要加上 @Async注解 不方便扩展
     * @return
     */
    @RequestMapping("/addOrderBySpring")
    public String addOrderBySpring(){
        UserMessageEntiy userMessageEntiy = new UserMessageEntiy(this, "1781781781@qq.com", "1818118111");
        applicationEventPublisher.publishEvent(userMessageEntiy);
        return "success";
    }
}
