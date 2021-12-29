package com.example.alip6.design_pattern.strategy.strategy_enu.impl;

import com.example.alip6.design_pattern.strategy.strategy_enu.PayStrategy;

public class WeChatPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用微信支付。。。。";
    }
}
