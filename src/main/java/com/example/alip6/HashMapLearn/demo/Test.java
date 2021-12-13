package com.example.alip6.HashMapLearn.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
    public static void main(String[] args) {
        String a1 = "a";
        Integer a2= 97;
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));

        System.out.println(120&1);

        System.out.println(1<<4);
        System.out.println(1<<30);
    }
}
