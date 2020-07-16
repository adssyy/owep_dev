package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.entity.CourseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = OwepAdminServiceApplication.class)
class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;

    /**
     * 限定只能查上级分类课程分类
     * 测试通过分类名称查询课程分类
     */
    @Test
    void findByCourseCategoryName() {
        CourseCategoryDTO byCourseCategoryName = categoryService.findByCourseCategoryName("reids");
        System.out.println(byCourseCategoryName);
    }

    /**
     * 获取所有的上级分类
     */
    @Test
    void findAllCourseCategory() {
        List<CourseCategoryDTO> allCourseCategory = categoryService.findAllCourseCategory();
        allCourseCategory.forEach(System.out::println);
    }

    /**
     * 测试获取下级分类
     */
    @Test
    void findAllSubCourseCategory() {
        List<CourseCategoryDTO> allSubCourseCategory = categoryService.findAllSubCourseCategory(2);
        allSubCourseCategory.forEach(System.out::println);
    }

    /**
     * 测试修改分类
     */
    @Test
    void alterCourseCategory() {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(1);
        courseCategory.setCategoryName("redis");
        courseCategory.setCategoryDesc("redis是一个单进程");
        categoryService.alterCourseCategory(courseCategory);
    }

    /**
     * 测试删除分类
     */
    @Test
    void deleteCourseCategory() {
        /*删除是逻辑删除*/
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(11);
        categoryService.deleteCourseCategory(courseCategory);


    }

    /**
     * 通过分页查询
     */
    @Test
    void findAllByPaging() {
        List<CourseCategoryDTO> allByPaging = categoryService.findAllByPaging(1, 3);
        allByPaging.forEach(System.out::println);
    }


    /**
     * 测试添加分类
     */
    @Test
    void addCourseCategory(){
        //如果添加下级分类，需要指定上级分类的id
        CourseCategory courseCategory1 = new CourseCategory();
        courseCategory1.setCategoryName("springboot");
        courseCategory1.setCategoryDesc("手脚架，约定大于配置");
        courseCategory1.setCourseCategory(new CourseCategory());
        categoryService.addCourseCategory(courseCategory1);
    }
}