package com.example.alip6.mapper.design_pattern.chain_responsibility.handler;

import com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.bean.GatewayHandlerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 责任链数据库访问
 */
@Mapper
public interface GatewayHandlerMapper {
    @Select("Select handler_name as handlerName,prev_handler_id as preHanlerId,handler_id as handlerName from gateway_handler " +
            "where prev_handler_id = null ")
    GatewayHandlerEntity getFirstGatewayHandler();
    @Select("Select handler_name as handlerName,prev_handler_id as preHanlerId,handler_id as handlerName from gateway_handler" +
            "where handler_id = #{handlerId} ")
    GatewayHandlerEntity getDbHandler(String handlerId);

}
