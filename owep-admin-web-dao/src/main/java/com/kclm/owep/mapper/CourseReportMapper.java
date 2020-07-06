/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.CourseReport;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口CourseReportMapper
 *
 */
public interface CourseReportMapper {


    /**
     * 查询单个学生对单个课程的学习记录
     * @return
     */
    List<CourseReport> findAllByStudentIdAndCourseId(Serializable studentId, Serializable courseId);


    /**
     * 查询单个课程所有学生的学习记录
     * @param courseId
     * @return
     */
    List<CourseReport> findAllByCourseId(Serializable courseId);

    /**
     * 添加课程学习记录
     * @param courseReport
     */
    void saveCourseReport(CourseReport courseReport);

    /**
     * 通过id 删除记录
     * @param id
     */
    void deleteCourseReport(Serializable id);

    
}