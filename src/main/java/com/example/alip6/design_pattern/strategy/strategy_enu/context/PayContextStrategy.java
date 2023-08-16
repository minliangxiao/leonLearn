package com.example.alip6.design_pattern.strategy.strategy_enu.context;

import com.example.alip6.design_pattern.strategy.strategy_enu.PayStrategy;
import com.example.alip6.design_pattern.strategy.strategy_enu.factory.StrategyFactory;
import org.apache.commons.lang.StringUtils;

/**
 * 策略模式的上下文类
 */
// @Component 先注释了
public class PayContextStrategy {

    public String toPayHtml(String payCode){
        if (StringUtils.isEmpty(payCode)) {
            return "payCode不能为空";
        }
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(payCode);
        if (payStrategy == null){
            return "没有找到具体的策略实现类";
        }
        return payStrategy.toPayHtml();
    }
}
