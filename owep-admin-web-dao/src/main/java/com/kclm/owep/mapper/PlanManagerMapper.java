/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.PlanManager;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口PlanManagerMapper
 *
 */
public interface PlanManagerMapper {

    /**
     * 查询所有的方案
     * @return
     */
    List<PlanManager> findAll();

    /**
     * 分页查询所有的方案
     * @param offset
     * @param limit
     * @return
     */
    List<PlanManager> findPlanManagerLimit(int offset, int limit);

    /**
     * 添加方案
     * @param planManager
     */
    void savePlanManager(PlanManager planManager);

    /**
     * 通过list<id> 删除多个方案
     * @param integerList
     */
    void deleteByIds(List<Integer> integerList);

    /**
     * 通过id 删除方案
     * @param id
     */
    void deleteById(Serializable id);

    /**
     * 修改方案
     * @param planManager
     */
    void updatePlanManager(PlanManager planManager);

}