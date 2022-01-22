package com.example.alip6.design_pattern.state.context;

import com.example.alip6.design_pattern.state.service.OrderState;

/**
 * 状态模式的context上下文
 */
public class StateContext {

    private OrderState orderState;

    public StateContext(OrderState orderState) {
        this.orderState = orderState;
    }

    public void switchStateOrder(){
        orderState.orderService();
    }

}
