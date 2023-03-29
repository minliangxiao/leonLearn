package com.learn.test;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Condition;

/**
 * [一句话描述该类的功能]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/1/10 23:04]
 */
public class CashTest {
    @Cacheable(value = "")
    public String getCash(Condition condition){
        return null;
    }
}
