/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.CourseCategory;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口CourseCategoryMapper
 *
 */
public interface CourseCategoryMapper {

    /**
     * 查询所有的上级课程分类
     * @return
     */
    List<CourseCategory> findSupAll();

    /**
     * 通过上级课程分类id查询所有的下级课程分类id
     * @return
     */
    List<CourseCategory> findSubAll(Serializable id);

    /**
     * 通过课程分类名称查询
     * @param categoryName
     * @return
     */
    CourseCategory findByCategoryName(String categoryName);


    /**
     * 添加课程分类
     * @param courseCategory
     */
    void saveCourseCate(CourseCategory courseCategory);


    /**
     * 通过课程分类id 删除课程分类
     * @param id
     */
    void deleteSupById(Serializable id);

    /**
     * 修改课程分类
     * @param courseCategory
     */
    void updateCourseCate(CourseCategory courseCategory);


}