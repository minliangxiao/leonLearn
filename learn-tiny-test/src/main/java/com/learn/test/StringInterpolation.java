package com.learn.test;

import com.alibaba.druid.sql.visitor.functions.If;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [字符串替换]
 *
 * @author : [liang.huang]
 * @version : [v1.0]
 * @createTime : [2022/8/1 21:32]
 */
public class StringInterpolation {


    /**获取完整句子
     * @param content  未被替换符号字符串
     * @param kv 键值对
     * @return 替换符号的句子
     */
    public static String getContent(String content,HashMap<String,String> kv) throws Exception {
//        String pattern = "\\{\\{(.+?)\\}\\}";
        String pattern = "\"(.+?)\"\\:";
        String pattern2 = "\\:(.+?)\\,";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        StringBuffer sb = new StringBuffer();
        while (m.find())
        {
            String key = m.group(1).trim().replace("\\\\","");
            String value = kv.get(key);
            if (value==null|| (value.length() <=0)) {
               throw  new Exception("缺少值对象"+key);
            }
            m.appendReplacement(sb, value == null ? "" : value);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /** 测试
     * @param args 参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        String content = "我的名字是 {{ name }}，我永远是 {{ age }}。";
        HashMap<String, String> kv = new HashMap<>();
        kv.put("name","Bill");
        kv.put("age","21");
        System.out.println(getContent(content,kv));

    }

}
