package com.example.alip6.design_pattern.decorate.service;

import com.example.alip6.design_pattern.decorate.aop.ExtMyCache;
import com.example.alip6.design_pattern.decorate.bean.UserEntity;
import com.example.alip6.mapper.design_pattern.decorate.DecorateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {
    @Autowired
    private DecorateUserMapper userMapper;
    @RequestMapping("getUser")
    @ExtMyCache
    public UserEntity getUser(Integer userId){
        return userMapper.findByUser(userId);
    }
}
