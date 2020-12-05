package com.kclm.owep.web.controller;

import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.entity.CourseCategory;
import com.kclm.owep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/training/courseCategory")

public class CourseCategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取所有父分类
     * @return
     */
    @RequestMapping(value = "/getCourseCategory",produces = "application/json")
    @ResponseBody
    public Object getCourseCategory(){
        List<CourseCategoryDTO> all = categoryService.findAllCourseCategory();
        return all;
    }

    /**
     * 添加父分类
     * @param courseCategory
     * @return
     */
    @RequestMapping("/addCourseCategory")
    @ResponseBody
    public String addCourseCategory(@RequestBody CourseCategory courseCategory){

        categoryService.addCourseCategory(courseCategory);
        return "success";
    }

    /**
     * 添加子分类
     * @param categoryName
     * @param categoryDesc
     * @param parentId
     * @return
     */
    @RequestMapping("/addSonCourseCategory")
    @ResponseBody
    public String addSonCourseCategory(String categoryName,String categoryDesc,Integer parentId){
        System.out.println(categoryName+","+categoryDesc+","+parentId);
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCategoryName(categoryName);
        courseCategory.setCategoryDesc(categoryDesc);
        if(parentId != null) {
            courseCategory.setCourseCategory(categoryService.selectById(parentId));
        }
        categoryService.addCourseCategory(courseCategory);
        return "success";
    }

    /**
     * 修改分类
     * @param courseCategory
     * @return
     */
    @RequestMapping("/updateCourseCategory")
    @ResponseBody
    public String updateCourseCategory(@RequestBody CourseCategory courseCategory){
        categoryService.alterCourseCategory(courseCategory);
        return "success";
    }

    /**
     * 通过父分类的id获取子分类
     * @param id
     * @return
     */
    @RequestMapping(value="/getSubCourseCategory",produces = "application/json")
    @ResponseBody
    public Object getSubCourseCategory(Integer id){
        List<CourseCategoryDTO> allSubCourseCategory = categoryService.findAllSubCourseCategory(id);
        return allSubCourseCategory;
    }

    /**
     * 通过id删除分类
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(Integer id){
        categoryService.deleteCourseCategory(id);
        return "success";
    }
}
