package com.example.alip6.design_pattern.factory.factory;

import com.example.alip6.design_pattern.factory.PaymentService;
import com.example.alip6.design_pattern.factory.impl.AliPayService;
import com.example.alip6.design_pattern.factory.impl.WeChatService;

/**
 * 工厂主类
 */
public class PayMentFactory {
    public static PaymentService getPaymentService(String payType){
        PaymentService paymentService = null;
        switch (payType){
            case "ali_pay":
                paymentService = new AliPayService();
                break;
            case "wechat_pay":
                paymentService = new WeChatService();
                break;
        }
        Class<PaymentService> paymentServiceClass = PaymentService.class;
        Class<?>[] declaredClasses = paymentServiceClass.getDeclaredClasses();
        paymentServiceClass.getEnclosingClass();
        return paymentService;
    }
}
