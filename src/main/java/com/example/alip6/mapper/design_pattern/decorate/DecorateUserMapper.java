package com.example.alip6.mapper.design_pattern.decorate;

import com.example.alip6.design_pattern.decorate.bean.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DecorateUserMapper {
   @Select("select * From p5_user where user_id = #{userId}")
    UserEntity findByUser(Integer userId);
}
