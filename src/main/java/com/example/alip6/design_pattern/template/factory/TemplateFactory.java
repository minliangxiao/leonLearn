package com.example.alip6.design_pattern.template.factory;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.utils.SpringUtil;
import com.example.alip6.design_pattern.template.AbstractPayCallbackTemplate;

/**
 * 模板设计模式的工厂类
 */
public class TemplateFactory {

    public static AbstractPayCallbackTemplate getPayCallbackTemplate(String templateId){
        AbstractPayCallbackTemplate payCallbackTemplate = (AbstractPayCallbackTemplate) SpringUtil.getBean(templateId);
        return payCallbackTemplate;
    }
}
