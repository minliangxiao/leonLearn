package com.example.alip6.design_pattern.facede.controller;

import com.example.alip6.design_pattern.facede.service.PayCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayCallbackController {
    @Autowired
    private PayCallbackService payCallbackService;
    @RequestMapping("/callBack")
    public String  callBack(){
        payCallbackService.callBack();
        return "success";
    }

}
