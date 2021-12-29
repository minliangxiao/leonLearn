package com.example.alip6.mapper.design_pattern.strategy;

import com.example.alip6.design_pattern.strategy.strategy_spring_sql.entity.PayStrategyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentChannnelMapper {
    @Select("select id as id,channel_name as channelName,channel_id as channelId,strategy_bean_id as strategyBeanId from payment_channel where channel_id = #{payCode} ")
    PayStrategyEntity getPaymentChannel(String payCode);
}
