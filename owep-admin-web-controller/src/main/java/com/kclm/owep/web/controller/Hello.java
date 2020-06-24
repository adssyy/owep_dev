package com.kclm.owep.web.controller;

import com.kclm.owep.dto.UserDto;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/******************
 * @Author yejf
 * @Description TODO
 */
@Controller
public class Hello {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "Hello, Spring Boot";
    }

    @RequestMapping("/user/all")
    @ResponseBody
    public List<UserDto> findAll() {
        return this.userService.findAll();
    }

    @RequestMapping("/page/index")
    public String helloThymeleaf() {
        System.out.println(" 进入 helloThymeleaf 方法");
        return "demo/index";
    }
}
