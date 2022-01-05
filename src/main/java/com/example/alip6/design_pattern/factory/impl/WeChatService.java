package com.example.alip6.design_pattern.factory.impl;

import com.example.alip6.design_pattern.factory.PaymentService;

public class WeChatService  implements PaymentService {
    @Override
    public void pay() {
        System.out.println("微信支付。。。");
    }
}
