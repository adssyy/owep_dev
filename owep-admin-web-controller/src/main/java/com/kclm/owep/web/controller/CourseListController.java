package com.kclm.owep.web.controller;

import com.alibaba.fastjson.JSON;
import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.service.CategoryService;
import com.kclm.owep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/training/courseList")
public class CourseListController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 显示课程信息
     * @return
     */
    @RequestMapping(value="/getCourseList" ,produces = "application/json")
    @ResponseBody
    public Object getCourseList(){
        List<CourseDTO> allCourse = courseService.findAllCourse();
        allCourse.forEach(System.out::println);
        return allCourse;
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @RequestMapping("/addCourse")
    public String addCourse(Course course){
        System.out.println("*******************-*-*-*-*-*-**-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-**-*-*--****-*-*-*--**-*---*-");
        courseService.addCourse(course);
        return "forward:/owep/training/courseList";
    }

    /**
     * 删除复选框选中的课程
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSelected")
    @ResponseBody
    public String deleteSelected(@RequestBody List<Integer> ids){
       //courseService.deleteCourseByIds(ids);
        for(Integer id : ids){
            System.out.println("delete userId:"+id);
            courseService.deleteCourseById(id);
        }
        return "success";
    }

    /**
     * 通过id删除课程
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("id") Integer id){
        System.out.println("***************************************************************************"+id);
        courseService.deleteCourseById(id);
        //return "forward:/owep/training/courseList";
        return "success";
    }

    /**
     * 通过课程名查询课程
     * @param courseName
     * @return
     */
    @RequestMapping("/findCourseByName")
    public Object findCourseByName(String courseName){
        List<CourseDTO> courseByCourseName = courseService.findCourseByCourseName(courseName);
        return courseByCourseName;
    }

    /**
     * 修改课程
     * @param course
     * @return
     */
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course){
        courseService.alterCourse(course);
        return "forward:/owep/training/courseList";
    }

    /**
     * 到达章页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/toChapter")
    public String toChapter(Model model, HttpServletRequest request){
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        Course course = courseService.selectById(courseId);
        System.out.println("*****************************************"+courseId);
        model.addAttribute("courseId",courseId);
        model.addAttribute("courseName",courseName);
        model.addAttribute("course",course);
        return "/training/chapter";
    }

    /**
     * 获取课程分类信息
     * @return
     */
    @RequestMapping(value = "/getCourseCategory",produces = "application/json")
    @ResponseBody
    public Object getCourseCategory(){
        Map<String,Map<String,String>> map = new HashMap<>();
        Map<String,String> parentCategory = new HashMap<>();

        List<CourseCategoryDTO> categoryDTOS = categoryService.findAllCourseCategory();
        for(CourseCategoryDTO courseCategoryDTO:categoryDTOS){
            parentCategory.put(String.valueOf(courseCategoryDTO.getId()),courseCategoryDTO.getCategoryName());
            Map<String,String> subCategory = new HashMap<>();
            List<CourseCategoryDTO> subCategoryDTOS = categoryService.findAllSubCourseCategory(courseCategoryDTO.getId());
            for(CourseCategoryDTO subCourseCategoryDTO:subCategoryDTOS){
                subCategory.put(String.valueOf("id"+subCourseCategoryDTO.getId()),subCourseCategoryDTO.getCategoryName());
            }
            map.put(String.valueOf(courseCategoryDTO.getId()),subCategory);
        }
        map.put("86",parentCategory);
        return map;
    }




}
