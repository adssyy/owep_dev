package com.kclm.owep.web.controller;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {

    @RequestMapping("/schemaList")
    public String schemaList(){
        System.out.println("=====================================");
        return "/training/schemaList";
    }

    @RequestMapping("/courseList")
    public String courseList(){
        return "/training/courseList";
    }

    @RequestMapping("/courseCategory")
    public String courseCategory(){
        return "/training/courseCategory";
    }



}
