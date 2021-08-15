package com.example.alip6.lamdbaAndStream;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * api
 */
public class OptionalDemo1 {
    public static void main(String[] args) {
        String userName = null;
        /*Optional中的
         *ofNullable() 可以允许传递一个空值对象
         * of()  不允许传递一个空值对象
         * isPresent() 返回false表示值为空的 返回true表示值不为空
         * .orElse()在值为空的情况下能够设置默认值
        * */
        Optional<String> optiona1 = Optional.ofNullable(userName);
//        System.out.println(optiona1.get());
        System.out.println(optiona1.isPresent());
        /*设置默认值*/
        String growyb = optiona1.orElse("growyb");
        System.out.println(growyb);

        /*过滤 如果匹配到相关内容则返回true 如果为null也会返回false*/
        boolean present = optiona1.filter(s -> "growyb".equals(s)).isPresent();
        System.out.println(present);

    }
}
