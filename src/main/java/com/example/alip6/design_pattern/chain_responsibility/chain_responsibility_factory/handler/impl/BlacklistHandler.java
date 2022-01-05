package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.GatewayHandler;

/**
 * 黑名单
 */
public class BlacklistHandler  extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第二个步骤。。黑名单");
        nextService();
    }
}
