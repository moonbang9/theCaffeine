package com.theCaffeine.mes.common.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String main(){
        return "layout/index";
    }
	
}
