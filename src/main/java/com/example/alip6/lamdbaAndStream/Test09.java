package com.example.alip6.lamdbaAndStream;

import com.example.alip6.function.Message;

import java.util.function.Function;

public class Test09 {
    public static void main(String[] args) {
        Message message =Test09::getMessage;
        message.get("hi function");

        /*案例二*/
       Function<String,Integer> function= String::length;
        System.out.println(function.apply("helellel"));
    }
    public static void getMessage(String a){
        System.out.println("消息为"+a);
    }
}
