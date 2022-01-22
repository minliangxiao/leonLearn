package com.example.alip6.design_pattern.state.service.impl;

import com.example.alip6.design_pattern.state.service.OrderState;
import org.springframework.stereotype.Component;

@Component
public class InTransitOrderState implements OrderState {
    @Override
    public Object orderService() {
        System.out.println("切换成已运输状态");
        return "已运输";
    }
}
