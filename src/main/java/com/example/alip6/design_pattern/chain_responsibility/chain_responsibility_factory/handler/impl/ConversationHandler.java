package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.GatewayHandler;

/**
 * 会话
 */
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三个步骤。。。会话");
    }
}
