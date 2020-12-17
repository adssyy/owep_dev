/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.entity.CourseCategory;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 11:08
 *@Description 课程分类业务层接口
 *
 */
public interface CategoryService {

    /**
     * 通过分类名查询分类
     * @param courseCategoryName
     * @return
     */
    List<CourseCategoryDTO> findByCourseCategoryName(String courseCategoryName);


    /**
     * 添加课程分类
     * @param courseCategory
     */
    void addCourseCategory(CourseCategory courseCategory);


    /**
     *  查询所有的上级课程分类
     * @return
     */
    List<CourseCategoryDTO> findAllCourseCategory();

    CourseCategory selectById(Serializable id);
    /**
     * 通过上级id 查询所有下级分类
     * @param parentId
     * @return
     */
    List<CourseCategoryDTO> findAllSubCourseCategory(Serializable parentId);

    /**
     * 修改分类课程
     * @param courseCategory
     * @return
     */
    int alterCourseCategory(CourseCategory courseCategory);

    /**
     *  通过分类id 删除
     * @param id
     * @return
     */
    int deleteCourseCategory(Serializable id);



    /**
     * 分页查询  课程分类
     * @param page
     * @param size
     * @return
     */
    List<CourseCategoryDTO> findAllByPaging(int page, int size);


}
