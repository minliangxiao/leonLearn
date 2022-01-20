package com.example.alip6.design_pattern.strategy.strategy_enu.factory;

import com.example.alip6.design_pattern.strategy.strategy_enu.PayStrategy;
import com.example.alip6.design_pattern.strategy.strategy_enu.enumeration.PayEnumStrategy;

/**
 * 产生策略的工厂类
 */
public class StrategyFactory {
    public static PayStrategy getPayStrategy(String strategyType){
        // 获取到枚举类里面的策略类对应的全路径
        String className = PayEnumStrategy.valueOf(strategyType).getClassName();
        try {
            return (PayStrategy) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        PayEnumStrategy ali_pay = PayEnumStrategy.valueOf("ALI_PAY");
        System.out.println(ali_pay);
    }
}
