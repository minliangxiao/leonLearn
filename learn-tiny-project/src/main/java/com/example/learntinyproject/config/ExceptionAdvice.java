package com.example.learntinyproject.config;

import com.example.learntinyproject.Enum.AppCode;
import com.example.learntinyproject.dto.ReturnMessage;
import com.example.learntinyproject.tinyexception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * [spring mvc 自定义统一异常处理类]
 自定义统一异常处理类
 *	步骤：
 *  	1、通过注解，声明异常处理类
 *  	2、编写方法，在方法内部处理异常，构造响应数据
 *  	3、方法上编写注解@ExceptionHandler，指定此方法可以处理的异常类型
 *
 *	使用Spring推荐的ResponseEntity作为返回值时：
 *		1. 可以手动修改返回的状态码和响应体
 *		2. 此类不需要加@ResponseBody
 *
 *	如果是自定义的返回结果类作为返回值时：
 *		1.比如直接使用上面的ReturnMessage作为返回值, 则需要在此类或者方法上添加@ResponseBody
 *	    2.此时可以使用@RestControllerAdvice注解， 它等同于ControllerAdvice + @ResponseBody

 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/1/22 21:31]
 */
@ControllerAdvice
public class ExceptionAdvice {
    //处理业务异常
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handlerBusinessException(BusinessException be) {
        be.printStackTrace();
        AppCode appCode = be.getAppCode();
        ReturnMessage returnMessage = new ReturnMessage(
                appCode.getCode(),
                appCode.getMsg(),
                null);
        return ResponseEntity.status(appCode.getCode())
                .body(returnMessage);
    }

    //处理不可预知的异常 (像什么空指针、数组下标越界、类型转换等非业务异常)
    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception e) {
        e.printStackTrace();
        ReturnMessage returnMessage = new ReturnMessage(
                AppCode.SERVICE_ERROR.getCode(),
                e.getMessage(),
                null);
        /**
         *   拓展：
         *   HttpStatus 是Spring自带的状态码信息类
         *   源码中的定义 ：
         *           INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
         *   可以看到 INTERNAL_SERVER_ERROR代表的就是500状态码，服务端异常
         *   这种写法语义性更强，且不用自己再去定义
         *
         * 	 但是我这里并没有使用，而是选择了自定义状态码
         */
        return ResponseEntity.status(AppCode.SERVICE_ERROR.getCode())
                .body(returnMessage);
    }

}
