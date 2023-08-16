package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.factory;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl.BlacklistHandler;
import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl.ConversationHandler;
import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_factory.handler.impl.CurrentLimitHandler;

public class FactoryHandler {
    public static CurrentLimitHandler getFirstHandler(){
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        BlacklistHandler blacklistHandler = new BlacklistHandler();
        ConversationHandler conversationHandler = new ConversationHandler();
        currentLimitHandler.setNextHandler(blacklistHandler);
        blacklistHandler.setNextHandler(conversationHandler);
        return currentLimitHandler;

    }

    public static void main(String[] args) {
        CurrentLimitHandler firstHandler = FactoryHandler.getFirstHandler();
        firstHandler.service();
    }
}
