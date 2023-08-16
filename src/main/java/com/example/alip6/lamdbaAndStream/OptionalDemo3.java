package com.example.alip6.lamdbaAndStream;

import com.example.alip6.bean.User;

import java.util.Optional;

/**
 * 案例二
 */
public class OptionalDemo3 {
    private static User user;
    public static void main(String[] args) {

    }
    public static User getUser(){
        /*
        * orElseGet()-- 写函数的接口的形式 赋默认值
        * orElse() ---直接传递默认值
        * */
//        return Optional.ofNullable(user).orElse(createUser());// 这种清理会报空 因为没有将创建好的user赋值给全局对象user所以一定会报空
      /*  return Optional.ofNullable(user).orElseGet(() -> {
            user = createUser();
            return user;
        });*/
        // 优化成方法引入
        return Optional.ofNullable(user).orElseGet(OptionalDemo3::getUser);
    }

    private static User createUser(){
        return new User("gowpyb",21);
    }

    public static User orElseGet(){
        user = createUser();
        return user;
    }

}
