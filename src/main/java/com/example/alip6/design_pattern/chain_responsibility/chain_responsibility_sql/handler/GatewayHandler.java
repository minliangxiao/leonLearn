package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler;

import org.springframework.stereotype.Component;

/**
 * 责任链的抽象类
 */

public  abstract class GatewayHandler {
      protected GatewayHandler gatewayHandler;
      public abstract void service();

      /**
       * 设置下一个环节的handler
       * @param gatewayHandler
       */
      public void setNextHandler(GatewayHandler gatewayHandler){
            this.gatewayHandler = gatewayHandler;
      }

      /**
       * 调用下一个环节的service
       */
      protected void nextService(){
            gatewayHandler.service();
      }
}
