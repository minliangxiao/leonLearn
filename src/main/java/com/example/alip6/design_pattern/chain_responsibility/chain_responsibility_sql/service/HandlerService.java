package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.service;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.bean.GatewayHandlerEntity;
import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.handler.GatewayHandler;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.utils.SpringUtil;
import com.example.alip6.mapper.design_pattern.chain_responsibility.handler.GatewayHandlerMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 补充知识点 对象之间的=是浅拷贝所以可以修改值
 */
@Service
public class HandlerService {
    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;

    private GatewayHandler firstGatewayHandler;

    /** 获取到责任链中的开头元素
     * @return
     */
    public GatewayHandler getFirstDbHandler(){
        if (this.firstGatewayHandler != null){
            return this.firstGatewayHandler;
        }
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        // 从spring容器中获取到责任链类
        String handlerId = firstGatewayHandlerEntity.getHandlerId();
        if (handlerId == null) {
            return  null;
        }
        GatewayHandler firstHandler = SpringUtil.getBean(handlerId, GatewayHandler.class);
        if (firstHandler == null) {
            return null;
        }
        // 使用递归实现下一个节点设置
        String nextHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        GatewayHandler temGatewayHandler = firstHandler;
        while (!StringUtils.isEmpty(nextHandlerId)){
            GatewayHandler nextGateway = SpringUtil.getBean(nextHandlerId, GatewayHandler.class);
            if (nextGateway == null){
                break;
            }
            GatewayHandlerEntity nextHandlerEntity = gatewayHandlerMapper.getDbHandler(nextHandlerId);
            nextHandlerId =  nextHandlerEntity.getNextHandlerId();
            temGatewayHandler.setNextHandler(nextGateway);
            temGatewayHandler = nextGateway;
        }
        this.firstGatewayHandler = firstHandler;
        return firstHandler;
    }


}
