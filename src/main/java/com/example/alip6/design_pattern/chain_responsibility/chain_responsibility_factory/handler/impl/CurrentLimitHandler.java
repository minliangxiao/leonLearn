package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.GatewayHandler;

/**
 * 限流
 */
public class CurrentLimitHandler extends GatewayHandler {

    @Override
    public void service() {
        System.out.println("第一个步骤。。限流");
        nextService();
    }
}
