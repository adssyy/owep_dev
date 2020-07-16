/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.PlanManager;

import java.time.LocalDateTime;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 11:02
 *@Description 方案中课程 业务接口
 *
 */
public class PlanManagerCourseDTO {

    /**
     *方案和课程中间表的主键
     */
    private Integer id;

    /**
     *方案编号
     */
    private String planNumber;

    /**
     *
     */
    private CourseDTO courseDTO;

    /**
     *阶段编号
     */
    private Integer stageNum;

    /**
     *阶段名称
     */
    private Integer stageName;

    /**
     *阶段内课程排序
     */
    private Integer courseOrder;



}
