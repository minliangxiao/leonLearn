package com.example.learn.concurrent.LearnConcurrent.ThreadAndConcurrent.mylogframe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogService {
    @RequestMapping("log")
    public String serviceLog(Integer id){

        return "请求成功";
    }
}
