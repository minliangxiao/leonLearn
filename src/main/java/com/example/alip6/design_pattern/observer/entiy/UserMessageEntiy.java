package com.example.alip6.design_pattern.observer.entiy;

import org.springframework.context.ApplicationEvent;

/**
 * 基于spring容器实现回掉机制
 */
public class UserMessageEntiy extends ApplicationEvent {
    private String phone;
    private String email;
    private String userId;
    /**
     * @param source 传入我们需要回掉的对象实例
     */
    public UserMessageEntiy(Object source) {
        super(source);
    }

    public UserMessageEntiy(Object source,String email,String phone) {
        super(source);
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserMessageEntiy{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
