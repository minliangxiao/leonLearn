package com.example.learn.netty.netty.example2.handler;

public class CalcBean {
    /**
     * 数字1
     */
    private int num1;
    /**
     * 数字2
     */
    private int num2;
    /**
     * 符号
     */
    private String symbol;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "CalcBean{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
