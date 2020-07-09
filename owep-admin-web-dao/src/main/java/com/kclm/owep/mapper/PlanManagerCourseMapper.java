/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.PlanManagerCourse;
import com.kclm.owep.mapper.common.BaseMapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口PlanManagerCourseMapper
 *
 */
public interface PlanManagerCourseMapper extends BaseMapper<PlanManager> {

    /**
     * 通过方案id查询设置的课程
     * @return
     */
    List<PlanManagerCourse> findAll(Serializable id);

    /**
     * 分页查询部分方案
     * @param offset
     * @param limit
     * @return
     */
    List<PlanManagerCourse> findPlanManagerCourseLimit(Serializable id,int offset, int limit);


    /**
     * 修改方案课程顺序
     * @param planManagerCourse
     */
    void updatePlanManagerCourse(PlanManagerCourse planManagerCourse);

}