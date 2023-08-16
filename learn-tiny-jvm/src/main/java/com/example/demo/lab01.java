package com.example.demo;

/**
 * [一句话描述该类的功能]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/7/21 09:22]
 */
public class lab01 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("fal").append("se").toString();
        System.out.println(str3.intern() == str3);
        String str4 = new StringBuilder("adadsds").append("dsa").toString();
        System.out.println(str4.intern() == str4);
    }

}
