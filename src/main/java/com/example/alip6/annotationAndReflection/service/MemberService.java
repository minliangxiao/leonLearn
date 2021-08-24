package com.example.alip6.annotationAndReflection.service;

import com.example.alip6.annotationAndReflection.annotation.GrowYb;
import com.example.alip6.annotationAndReflection.annotation.Limiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {
    @GetMapping("get")
    @Limiter(name = "get",token = 1)
    public String get(){
        return "my is get";
    }

    @GetMapping("add")
    @Limiter(name = "add",token = 5)
    public String add(){
        return "my is add";
    }


}
