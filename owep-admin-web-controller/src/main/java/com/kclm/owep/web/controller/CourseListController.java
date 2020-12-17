package com.kclm.owep.web.controller;

import com.alibaba.fastjson.JSON;
import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.CourseCategory;
import com.kclm.owep.entity.Result;
import com.kclm.owep.mapper.CourseCategoryMapper;
import com.kclm.owep.service.CategoryService;
import com.kclm.owep.service.CourseService;
import com.kclm.owep.utils.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/training/courseList")
public class CourseListController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CategoryService categoryService;

    private static final String FILE_UPLOAD_DIR = "D:/innerTestVideoServer/resources/";

    /**
     * 显示课程信息
     *
     * @return
     */
    @RequestMapping(value = "/getCourseList", produces = "application/json")
    @ResponseBody
    public Object getCourseList() {
        List<CourseDTO> allCourse = courseService.findAllCourse();

        return allCourse;
    }

    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    @RequestMapping("/addCourse")
    @ResponseBody
    public Object addCourse(Course course, @RequestParam("file") MultipartFile courseImage, HttpServletRequest request) {


        String id = request.getParameter("categoryId");
        CourseCategory category = categoryService.selectById(id);
        /*String pid = request.getParameter("parentCategoryId");
        CourseCategory parentCategory = categoryService.selectById(pid);
        request.setAttribute("parentCategory",parentCategory.getCategoryName());
        request.setAttribute("category",category.getCategoryName());*/
        course.setCourseCategory(category);

        final String originalFilename = courseImage.getOriginalFilename();


        //生成薪的文件名=-----选做

        String fileName = UUID.randomUUID().toString();
        //获取原来的扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName += suffix;
        course.setCourseImage(fileName);
        //IO流操作
        try {
            courseImage.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        course.setCourseOpenStatus(1);
        course.setVideoStatus(1);
        course.setIsDelete(1);
        courseService.addCourse(course);
        return new Result("200", "ok");
    }

    /**
     * 删除复选框选中的课程
     *
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSelected")
    @ResponseBody
    public String deleteSelected(@RequestBody List<Integer> ids) {
        //courseService.deleteCourseByIds(ids);
        for (Integer id : ids) {

            courseService.deleteCourseById(id);
        }
        return "success";
    }

    /**
     * 通过id删除课程
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("id") Integer id) {

        courseService.deleteCourseById(id);
        //return "forward:/owep/training/courseList";
        return "success";
    }

    /**
     * 通过课程名查询课程
     *
     * @param courseName
     * @return
     */
    @RequestMapping("/findCourseByName")
    @ResponseBody
    public Object findCourseByName(String courseName) {

        List<CourseDTO> courseByCourseName = courseService.findCourseByCourseName(courseName);

        return courseByCourseName;
    }

    /**
     * 修改课程
     *
     * @param course
     * @return
     */
    @RequestMapping("/updateCourse")
    @ResponseBody
    public Object updateCourse(Course course, @RequestParam("file") MultipartFile courseImage, HttpServletRequest request) {


        String id = request.getParameter("alterCategoryId");
        CourseCategory category = categoryService.selectById(id);
        course.setCourseCategory(category);

        final String originalFilename = courseImage.getOriginalFilename();


        //生成薪的文件名=-----选做

        String fileName = UUID.randomUUID().toString();
        //获取原来的扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName += suffix;
        course.setCourseImage(fileName);
        //IO流操作
        try {
            courseImage.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        course.setCourseOpenStatus(1);
        course.setVideoStatus(1);
        course.setIsDelete(1);
        courseService.alterCourse(course);
        return new Result("200", "ok");
    }

    /**
     * 到达章页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/toChapter")
    public String toChapter(Model model, HttpServletRequest request) {
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        Course course = courseService.selectById(courseId);

        model.addAttribute("courseId", courseId);
        model.addAttribute("courseName", courseName);
        model.addAttribute("course", course);
        return "/training/chapter";
    }

    /**
     * 获取课程分类信息
     *
     * @return
     */
    @RequestMapping(value = "/getCourseCategory", produces = "application/json")
    @ResponseBody
    public Object getCourseCategory() {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> parentCategory = new HashMap<>();

        List<CourseCategoryDTO> categoryDTOS = categoryService.findAllCourseCategory();
        for (CourseCategoryDTO courseCategoryDTO : categoryDTOS) {
            parentCategory.put(String.valueOf(courseCategoryDTO.getId()), courseCategoryDTO.getCategoryName());
            Map<String, String> subCategory = new HashMap<>();
            List<CourseCategoryDTO> subCategoryDTOS = categoryService.findAllSubCourseCategory(courseCategoryDTO.getId());
            for (CourseCategoryDTO subCourseCategoryDTO : subCategoryDTOS) {
                subCategory.put(String.valueOf("id" + subCourseCategoryDTO.getId()), subCourseCategoryDTO.getCategoryName());
            }
            map.put(String.valueOf(courseCategoryDTO.getId()), subCategory);
        }
        map.put("86", parentCategory);
        return map;
    }

    /**
     * 滑动按钮改变状态
     *
     * @param courseId
     * @param status
     */
    @GetMapping("/switch")
    @ResponseBody
    public void postAdminValidSwitch(@RequestParam Integer courseId, @RequestParam Integer status) {

        if (status == null) {

            return;
        }
        if (status == 1) {

            courseService.activate(courseId);
        } else {

            courseService.deactivate(courseId);
        }
    }

    /**
     * 获取所有父分类
     *
     * @return
     */
    @RequestMapping(value = "/getParentCategory")
    @ResponseBody
    public Object getParentCategory() {
        List<CourseCategoryDTO> all = categoryService.findAllCourseCategory();
        Map map = new HashMap();
        map.put("value", all);
        return map;
    }

    /**
     * 获取子分类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getSubCategory")
    @ResponseBody
    public Object getSubCategory(Integer id) {
        List<CourseCategoryDTO> allSubCourseCategory = categoryService.findAllSubCourseCategory(id);
        Map map = new HashMap();
        map.put("value", allSubCourseCategory);
        return map;
    }

    /**
     * 回显数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(Integer id) {
        Course course = courseService.selectById(id);


        return course;
    }


}
