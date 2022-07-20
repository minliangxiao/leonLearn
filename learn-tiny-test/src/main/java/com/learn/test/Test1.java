package com.learn.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    public static void main(String[] args) throws ParseException {
//        String s = "100001";
////        System.out.println(Integer.valueOf(s));
//        System.out.println(Integer.valueOf("1.0"));
//        Objects.requireNonNull(s);
//        List.of("ad","aa");
        List<String> strings = Collections.unmodifiableList(Arrays.asList("aaa", "bbbb"));
         strings.add("cc");

    }

    public static Date getSeasonEndDate (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, (month + 3) / 3 * 3);
        calendar.set(Calendar.DATE, 1);
        return new Date(calendar.getTime().getTime() - 24 * 60 * 60 *1000);
    }

    /**
     * 计算某日期所在季度开始日期
     * 季度划分：1、2、3， 4、5、6， 7、8、9， 10、11、12
     */
    public static Date getSeasonStartDate (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month / 3 * 3);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

}
