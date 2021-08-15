package com.example.alip6.lamdbaAndStream;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 案例
 */
public class OptionalDemo2 {
    public static void main(String[] args) {
        String userName = "growyb";
        Optional<String> optional1 = Optional.ofNullable(userName);
        optional1.ifPresent(System.out::println);

        /*另外一种垃圾写法*/
        boolean present = optional1.isPresent();
        if (present){
            System.out.println(userName);
        }
    }
}
