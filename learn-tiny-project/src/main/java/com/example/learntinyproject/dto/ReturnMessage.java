package com.example.learntinyproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * [springmvc统一异常处理案列]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/1/18 17:32]
 */
@Data                          //lombok注解 提供get/set、toString、equal等实体类都有的方法
@NoArgsConstructor             //lombok注解 提供无参构造
@AllArgsConstructor
public class ReturnMessage <T> implements Serializable {
    // 状态码
    private Integer code ;
    // 提示信息
    private  String msg;
    // 数据
    private T data;


    /**
     * 创建一个要返回的消息对象
     * @param code  状态码
     * @param msg   错误信息
     * @param data  数据
     * @return
     * @param <T>   声明这个静态方法是一个泛型方法
     */
    public static <T> ReturnMessage<T> create(Integer code, String msg, T data) {
        ReturnMessage<T> r = new ReturnMessage<T>(code, msg, data);
        return r;
    }
}
