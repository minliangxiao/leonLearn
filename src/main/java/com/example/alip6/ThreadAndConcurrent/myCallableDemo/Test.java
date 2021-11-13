package com.example.alip6.ThreadAndConcurrent.myCallableDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      String sql = "select x.*  from (\n" +
              "SELECT B_ANAL_DIRTY_CNBD,\n" +
              "  B_ANAL_ACCRINT_CNBD,\n" +
              "  B_ANAL_NET_CNBD,\n" +
              "  B_ANAL_YIELD_CNBD\n" +
              "FROM T8_BOND_ANALYSISCNBD\n" +
              "WHERE TRADEDATE=\n" +
              "  (SELECT MAX(TRADEDATE)\n" +
              "  FROM T8_BOND_ANALYSISCNBD\n" +
              "  WHERE TRADEDATE<=$S{settle_date})\n" +
              "AND MARKET_CODE=$S{bond_market}\n" +
              "AND BOND_CODE  =$S{ftool_code}\n" +
              "union all\n" +
              "SELECT 0 as B_ANAL_DIRTY_CNBD,\n" +
              "  0 as B_ANAL_ACCRINT_CNBD,\n" +
              "  0 as B_ANAL_NET_CNBD,\n" +
              "  0 as B_ANAL_YIELD_CNBD\n" +
              "FROM dual) x\n" +
              " LIMIT 1";

        String pattern = "(\\$)(.*?)\\}\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(sql);
        while (m.find()) {
        }
            System.out.println("Found value: " + m.group(2));

    }
}
