package com.example.alip6.design_pattern.state.controller;

import com.example.alip6.design_pattern.state.context.StateContext;
import com.example.alip6.design_pattern.state.service.OrderState;
import com.example.alip6.design_pattern.strategy.strategy_spring_sql.utils.SpringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @RequestMapping("/order")
    public String order(String stateBeanId){
        // 使用上下文获取bean中对象
        OrderState orderState = SpringUtil.getBean(stateBeanId, OrderState.class);
        // 使用状态模式的上下文切换到不同的状态
        StateContext stateContext = new StateContext(orderState);
        stateContext.switchStateOrder();
        return "success";
    }
}
