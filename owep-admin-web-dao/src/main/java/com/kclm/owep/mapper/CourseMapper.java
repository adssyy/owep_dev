/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Course;
import com.kclm.owep.mapper.common.BaseMapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口CourseMapper
 *
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 通过分页查询部分
     * @return
     */
    List<Course> findCourseLimit(int offset, int limit);


    /**
     * 通过课程名称查询课程
     * @param CourseName
     * @return
     */
    List<Course> findByCourseName(String CourseName);


}