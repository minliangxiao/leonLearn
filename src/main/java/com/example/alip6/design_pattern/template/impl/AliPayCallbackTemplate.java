package com.example.alip6.design_pattern.template.impl;

import com.example.alip6.design_pattern.template.AbstractPayCallbackTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class AliPayCallbackTemplate extends AbstractPayCallbackTemplate {
    @Override
    protected String resultFail() {
        return "fail";
    }

    @Override
    protected String resultSuccess() {
        return "Success";
    }

    @Override
    protected String asyncService(Map<String, String> verifySignature) {
        System.out.println("第三步。执行修改订单状态和返回不同的支付结果");
        // 伪代码
        String payStatus = verifySignature.get("aliPayMentStatus");
        if (payStatus.equals("1")) {
            String payOrderNumber = verifySignature.get("aliPayOrderNumber");
            System.out.println("订单为："+payOrderNumber+"支付成功");
        }
        return resultSuccess();
    }

    @Override
    protected Map<String, String> verifySignature() {
        /*
        * 伪代码 假设为阿里支付的回调报文
        * */
        System.out.println("第一步 解析支付宝报文");
        HashMap<String, String> verifySignature = new HashMap<>();
        verifySignature.put("price","1399");
        verifySignature.put("orderDes","订单详情");
        // 支付状态为1 表示为成功...
        verifySignature.put("aliPayMentStatus","1");
        verifySignature.put("aliPayOrderNumber","20200200");
        // 假设阿里支付的回调报文到这里就结束了
        // 自定义一个状态以方便本地系统判断是否支付成功或者签名成功。。
        verifySignature.put("analysisCode","200");
        return verifySignature;

    }
}
