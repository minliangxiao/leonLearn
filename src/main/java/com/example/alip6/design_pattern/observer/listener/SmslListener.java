package com.example.alip6.design_pattern.observer.listener;

import com.example.alip6.design_pattern.observer.entiy.UserMessageEntiy;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 依据spring 来实现回调机制这个类相当于原来的 SmsObserver+MysubJect类
 */
@Component
public class SmslListener implements ApplicationListener<UserMessageEntiy> {
    /** 这个方法就相当与原来 Observer 接口中的 sendMsg()方法   监听方法
     * @param userMessageEntiy
     */
    @Override
    public void onApplicationEvent(UserMessageEntiy userMessageEntiy) {
        System.out.println("短信："+userMessageEntiy.toString());
    }
}
