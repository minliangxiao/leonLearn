package com.example.alip6.design_pattern.facede.service;

import com.example.alip6.design_pattern.facede.facade.PayFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayCallbackService {
    @Autowired
    private PayFacade payFacade;
    public  void callBack(){
        payFacade.facadecallback();
    }
}
