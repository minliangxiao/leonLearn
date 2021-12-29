package com.example.alip6.design_pattern.strategy.strategy_enu.impl;

import com.example.alip6.design_pattern.strategy.strategy_enu.PayStrategy;

public class AliPayStrategy  implements PayStrategy {
    /**
     * @return
     */
    @Override
    public String toPayHtml() {

        return "调用阿里支付。。。";
    }
}
