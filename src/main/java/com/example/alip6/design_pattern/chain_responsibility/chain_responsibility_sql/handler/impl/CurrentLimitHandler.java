package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler.impl;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * 限流
 */
@Component
public class CurrentLimitHandler extends GatewayHandler {

    @Override
    public void service() {
        System.out.println("第一个步骤。。限流");
        nextService();
    }
}
