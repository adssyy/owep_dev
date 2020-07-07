/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 18:20
 * @Description 学员评价持久层接口
 */
public interface EvaluateMapper {

    /**
    *通过班级id查找学生评价的数据
    */
    Evaluate selectByClassId(Integer classId);

    /**
     * 更新评价内容
     */
    int updateEvaluate(@Param("evaluate") String evaluate,@Param("classId") String classId);
}