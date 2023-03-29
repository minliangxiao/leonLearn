package com.learn.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * [一句话描述该类的功能]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/2/8 16:40]
 */
public class test3 {

    public static void main(String[] args) {
                        System.out.print(f(2));
        ScriptEngineManager  manager= new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");


    }
    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }}}
}

