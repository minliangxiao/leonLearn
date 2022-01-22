package com.example.alip6.design_pattern.state.service.impl;

import com.example.alip6.design_pattern.state.service.OrderState;
import org.springframework.stereotype.Component;

@Component
public class ShippedAlreadyOrderState implements OrderState {
    @Override
    public Object orderService() {
        System.out.println("切换成已发货状态");
        return "发货";
    }
}
