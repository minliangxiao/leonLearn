package com.example.learntinyproject.tinyexception;

import com.example.learntinyproject.Enum.AppCode;
import lombok.Data;

/**
 * [springmvc 统一异常处理]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/1/18 17:43]
 */
@Data
public class BusinessException  extends  RuntimeException {
    private AppCode appCode;

    public BusinessException(AppCode appCode) {
        super(appCode.getMsg());
        this.appCode = appCode;
    }

}
