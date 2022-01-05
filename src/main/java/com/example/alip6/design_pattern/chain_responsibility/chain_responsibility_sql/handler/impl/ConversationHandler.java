package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler.impl;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * 会话
 */
@Component
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三个步骤。。。会话");
    }
}
