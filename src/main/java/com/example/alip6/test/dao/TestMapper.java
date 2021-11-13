package com.example.alip6.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    @Select("select * from T8_COMPUTE_DSCFG where  id =2")
    Map<String, String> getSql();
    @Select("${sql}")
    List<Map<String, Object>> getData(String sql,@Param("param")  Map<String, Object> param);
    @Select("select * from t8_profit_loss")
    List<Map<String, Object>> getTest();

}
