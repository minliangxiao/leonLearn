package com.example.alip6.design_pattern.strategy.strategy_spring_sql.impl;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy  implements PayStrategy {
    /**
     * @return
     */
    @Override
    public String toPayHtml() {

        return "调用阿里支付。。。";
    }
}
