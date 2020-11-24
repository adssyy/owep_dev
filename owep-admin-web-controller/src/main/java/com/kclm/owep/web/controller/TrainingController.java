package com.kclm.owep.web.controller;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/schemaList")
    public String schemaList(){
        return "/training/schemaList";
    }

    @RequestMapping("/courseList")
    public String courseList(){
        List<CourseDTO> allCourse = courseService.findAllCourse();
        return "/training/courseList";
    }

    @RequestMapping("/courseCategory")
    public String courseCategory(){
        return "/training/courseCategory";
    }

    @RequestMapping("/addCourse")
    public String addSource(){
        return null;
    }
}
