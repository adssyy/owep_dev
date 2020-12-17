/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.dto.PlanManagerDTO;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.PlanManagerCourse;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 9:17
 *@Description 方案业务接口
 *
 */
public interface PlanManagerService {

    /**
     * 查询所有的方案
     * @return
     */
    List<PlanManagerDTO> findAllPlanManager();

    /**
     * 分页查询     培养方案
     * @param page
     * @param size
     * @return
     */
    List<PlanManagerDTO> findAllPlanManagerByPaging(int page, int size);

    /**
     * 通过方案名称或编号查询方案
     * @param planManager
     * @return
     */
    List<PlanManagerDTO> findPlanManagerByField(PlanManager planManager);

    /**
     * 通过方案名查询
     * @param planManager
     * @return
     */
    List<PlanManager> findPlanManager(PlanManager planManager);

    /**
     * 修改方案
     * @param planManager
     * @return
     */
    int alterPlanManager(PlanManager planManager);

    /**
     * 通过ids 删除多个方案
     * @param ids
     * @return
     */
    int deletePlanManagerByIds(List<Serializable> ids);

    /**
     * 通过id 删除单个方案
     * @param id
     * @return
     */
    int deletePlanManagerById(Serializable id);

    PlanManager selectById(Serializable id);
    /**
     * 分页查询     方案中设置的课程
     */
    List<PlanManagerCourseDTO> findPlanCoursePaging(Serializable planId, int page, int size);


    /**
     * 对方案添加课程
     * @param planManagerCourse
     * @return
     */
    int addPlanManagerCourse(PlanManagerCourse planManagerCourse);

    /**
     * 删除方案中的课程
     * @param id
     * @return
     */
    int deltePlanManagerCourseById(Serializable id);

    /**
     * 对方案中的课程排序 上移 下移
     * @param up
     * @param down
     * @return
     */
    int shiftCellsUpOrDown(PlanManagerCourse up, PlanManagerCourse down);

    /**
     * 通过方案id,查询方案中的所有课程
     * @param id
     * @return
     */
    List<PlanManagerCourseDTO> findAllPlanManagerCourse(Serializable id);

    int addPlanManager(PlanManager planManager);

    Integer findMaxCourseOrder(PlanManagerCourse planManagerCourse);

    PlanManagerCourse findByCourseOrder(Integer courseOrder,Integer stageNum,PlanManager planManager);

    int activate(Integer id);
    int deactivate(Integer id);
    int updateStatus(PlanManager planManager);
}
