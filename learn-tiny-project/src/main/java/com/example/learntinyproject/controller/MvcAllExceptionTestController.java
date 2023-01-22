package com.example.learntinyproject.controller;

import com.example.learntinyproject.Enum.AppCode;
import com.example.learntinyproject.dto.ReturnMessage;
import com.example.learntinyproject.tinyexception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [spring mvc 统一异常处理测试]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/1/22 21:39]
 */
@RestController
public class MvcAllExceptionTestController {

    @RequestMapping("/mvc_test")
    public ReturnMessage mvcTest(){
        AppCode serviceError = AppCode.SERVICE_ERROR;
        throw  new BusinessException(serviceError);

    }

}
