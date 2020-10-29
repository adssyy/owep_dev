package com.kclm.owep.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    @GetMapping("/paramInfo.html")
    public String toSystemParamInfoPage(){
        return "system/paramInfo";
    }

    @GetMapping("/index.html")
    public String toRootPage(){return "index.html";}
}
