package com.example.alip6.design_pattern.template;

import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * 聚合支付模板设计模式的模板类
 */
public abstract class AbstractPayCallbackTemplate {

    /** 异步回调方法
     * @return
     */
    public String asyncCallBack(){
        // 1.验证参数和验证签名
        Map<String,String> verifySignature = verifySignature();
        // 2.日志收集
        payLog(verifySignature);
        // 3.获取验证签名状态
        String analysisCode = verifySignature.get("analysisCode");
        if (!analysisCode.equals("200")) {
            return resultFail();
        }
        //4. 更改数据库状态同时返回不同的支付结果
        return asyncService(verifySignature);
    }

    /**
     * 支付失败返回给第三方支付平台
     * @return
     */
    protected abstract String resultFail();

    /**
     * 支付成功返回给第三方支付平台
     * @return
     */
    protected abstract String resultSuccess();

    /**执行修改订单状态和返回不同的支付结果
     * @param verifySignature
     * @return
     */
    protected abstract String asyncService(Map<String, String> verifySignature);

    /** 验证参数和签名
     * @return
     */
    protected abstract Map<String, String> verifySignature();

    /**
     * 异步写日志，如果写入失败后期可以放入mq中
     * @param verifySignature
     */
    @Async
    public void payLog(Map<String, String> verifySignature) {
        System.out.println("第二步");
        System.out.println("写入数据库。。。。。"+verifySignature);
    }

}
