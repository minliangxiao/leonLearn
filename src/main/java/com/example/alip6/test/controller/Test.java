package com.example.alip6.test.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
      /* String a = "0" ;
       Double d = (Double) a;
        System.out.println(d);*/
       /* Integer a = null;
        System.out.println(a>0);*/
        BigDecimal bigDecimal = new BigDecimal("10000403566");
        System.out.println(obj2Integer(bigDecimal));
    }

    public static Integer obj2Integer(Object obj) {
        if (obj == null)
            return 0;

        try {
            String str = obj.toString();

            if (str.contains("E")) {// 判断是否是科学技术法，如果是，则进行转换
                DecimalFormat df = new DecimalFormat("#.#");
                str = df.format(obj);
            }

            int idx = str.indexOf(".");
            if (idx > -1)
                str = str.substring(0, str.indexOf("."));
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
