/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口PlanManagerMapper
 *
 */
@Mapper
public interface PlanManagerMapper extends BaseMapper<PlanManager> {


    /**
     * 分页查询所有的方案
     * @param offset
     * @param limit
     * @return
     */
    List<PlanManager> findPlanManagerLimit(int offset, int limit);

    /**
     * 查询方案的总记录数
     * @return
     */
    Long rowTotal();

}