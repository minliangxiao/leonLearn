package com.example.learntinyproject.Enum;

/**
 * springmvc 统一异常处理 全局枚据类
 */
public enum AppCode {


    SUCCESS(200,"成功"),
    SERVICE_ERROR(500, "服务器异常"),
    PASSWORD_ERROR(5001, "密码错误"),
    CHECK_ERROR(5002, "验证码无效");

    private int code;
    private String msg;
    AppCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
