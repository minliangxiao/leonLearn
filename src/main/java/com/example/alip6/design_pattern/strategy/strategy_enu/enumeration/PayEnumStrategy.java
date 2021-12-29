package com.example.alip6.design_pattern.strategy.strategy_enu.enumeration;

/**
 * 策略的枚举类  它存放了所有的策略的实现
 */
public enum PayEnumStrategy {


    /**
     * 支付宝支付
     */
    ALI_PAY("com.example.alip6.design_pattern.strategy.strategy.impl.AliPayStrategy"),

    WECHAT_PRAY("com.example.alip6.design_pattern.strategy.strategy.impl.WeChatPayStrategy");

    PayEnumStrategy (String className){
        this.setClassName(className);
    };

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    /**
     * class的完整地址
     */
    private String className;
}
