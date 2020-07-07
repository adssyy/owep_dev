/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.CourseComment;
import com.kclm.owep.mapper.common.BaseMapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口CourseCommentMapper
 *
 */
public interface CourseCommentMapper extends BaseMapper<CourseComment> {


    /**
     * 查询单个学生对单个课程所有的评价
     * @param studentId
     * @param courseId
     * @return
     */
    List<CourseComment> findByStuIdAndCourseId(Serializable studentId,Serializable courseId);

    /**
     * 通过学生id,查询单个学生对所有课程的评价
     * @param studentId
     * @return
     */
    List<CourseComment> findByStudentId(Serializable studentId);

    /**
     * 通过课程id,查询所有学生对课程的评价
     * @param CourseId
     * @return
     */
    List<CourseComment> findByCourseId(Serializable CourseId);


}