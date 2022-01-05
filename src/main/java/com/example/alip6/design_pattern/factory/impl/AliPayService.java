package com.example.alip6.design_pattern.factory.impl;

import com.example.alip6.design_pattern.factory.PaymentService;

public class AliPayService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("支付宝支付。。。。");
    }
}
