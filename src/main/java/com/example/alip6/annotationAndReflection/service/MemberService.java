package com.example.alip6.annotationAndReflection.service;

import com.example.alip6.annotationAndReflection.annotation.GrowYb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {
    @GetMapping("get")
    @GrowYb(name = "get",token = 1)
    public String get(){
        return "my is get";
    }

    @GetMapping("add")
    @GrowYb(name = "add",token = 5)
    public String add(){
        return "my is add";
    }


}
