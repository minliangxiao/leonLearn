package com.example.alip6.test.controller;

import com.example.alip6.mapper.test.dao.TestMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestComtroller  {
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("testMybatis")
    public String test(){
        //Map<String,String> sqlMap = testMapper.getSql();

        //String ds_sql = sqlMap.get("DS_SQL");
        String sql = "SELECT a.*,CASE BOND_PROP\n" +
                " WHEN 1 then '同业存单'\n" +
                " WHEN  3 THEN '地方政府债'\n" +
                " WHEN  19  THEN '国债'\n" +
                " WHEN 5 THEN '政策性金融债'\n" +
                " WHEN 4 THEN '央票'\n" +
                " WHEN 11 THEN '金融债'\n" +
                " WHEN  9 THEN '金融债'\n" +
                " WHEN 10 THEN '金融债'\n" +
                " ELSE '其他债券'\n" +
                " END 'SUBJECT_TYPE'\n" +
                " , (str_to_date(a.end_date,'yyyyMMdd')-str_to_date(a.begin_date,'yyyyMMdd')) QIXIAN,GetBondI9SubjectType(a.FULL_NAME,a.PUBLISHER_CODE,a.BOND_PROP) as\n" +
                " I9SUBJECTTYPE FROM T8_BOND_INFO a WHERE BOND_ID= #{_param.BOND_ID}";
        Map<String,Object> param = new HashMap<>();
        param.put("BOND_ID","3112011144");
        List<Map<String,Object>> oject = testMapper.getTest();
        for (Map<String, Object> map : oject) {
            System.out.println(map);
        }
        List<Map<String,Object>> data = testMapper.getData(sql,param);
        for (Map<String, Object> datum : data) {
            System.out.println(datum);
        }
        return null;
    }
}
