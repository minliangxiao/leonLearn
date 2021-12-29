package com.example.alip6.design_pattern.strategy.strategy_spring_sql.controller;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 策略模式测试controller
 *
 */
@RestController()
public class PayController {
    @Autowired
    private PayContextStrategy payContextStrategy;
    @RequestMapping("/toPayHtml")
    public String toPayHtml(String payCode){
        return payContextStrategy.toPayHtml(payCode);
    }
}
