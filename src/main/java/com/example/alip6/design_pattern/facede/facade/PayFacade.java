package com.example.alip6.design_pattern.facede.facade;

import com.example.alip6.design_pattern.facede.service.IntegralService;
import com.example.alip6.design_pattern.facede.service.LogService;
import com.example.alip6.design_pattern.facede.service.MsgService;
import com.example.alip6.design_pattern.facede.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  外观模式的外观接口
 */
@Component
public class PayFacade {
     @Autowired
    private LogService logService;
     @Autowired
    private PaymentService paymentService;
     @Autowired
    private IntegralService integralService;
     @Autowired
    private MsgService msgService;

     public void facadecallback(){
         //1.日志收集
         logService.logService();

         //2.修改订单状态
         paymentService.updatePaymentStatus();
         //3.调用积分服务接口
        integralService.addIntegral();
         //4.调用消息服务平台
        msgService.sendMsg();
     }

}
