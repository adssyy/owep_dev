package com.kclm.owep.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {

    /**
     *跳转到题库管理
     */
    @GetMapping("/titleList")
    public String titleList(){
        return "exam/titleList";
    }

    /**
     * 跳转到试题管理
     */
    @GetMapping("/testItemList")
    public String testItemList(){
        return "exam/testItemList";
    }

    /**
     * 跳转到试卷管理
     */
    @GetMapping("/paperManagementList")
    public String paperManagementList(){
        return "exam/paperManagementList";
    }

}
