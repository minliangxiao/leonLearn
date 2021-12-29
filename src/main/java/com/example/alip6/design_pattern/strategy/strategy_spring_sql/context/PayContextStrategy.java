package com.example.alip6.design_pattern.strategy.strategy_spring_sql.context;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.PayStrategy;
import com.example.alip6.design_pattern.strategy.strategy_spring_sql.entity.PayStrategyEntity;
import com.example.alip6.design_pattern.strategy.strategy_spring_sql.utils.SpringUtil;
import com.example.alip6.mapper.design_pattern.strategy.PaymentChannnelMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 策略模式的上下文类
 */
@Component
public class PayContextStrategy {
    @Autowired
    private PaymentChannnelMapper paymentChannnelMapper;

    public String toPayHtml(String payCode){
        if (StringUtils.isEmpty(payCode)) {
            return "payCode不能为空";
        }
        PayStrategyEntity paymentChannel = paymentChannnelMapper.getPaymentChannel(payCode);
        if (paymentChannel == null){
            return "没有查询到渠道";
        }
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if (StringUtils.isEmpty(strategyBeanId)) {
            return "数据库中没有注册strategyBeanId";
        }
        PayStrategy bean = SpringUtil.getBean(strategyBeanId, PayStrategy.class);
        return bean.toPayHtml();
    }
}
