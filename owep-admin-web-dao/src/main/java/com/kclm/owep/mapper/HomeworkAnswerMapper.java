/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.HomeworkAnswer;
/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 18:06
 * @Description 学员作业完成持久层接口
 */
public interface HomeworkAnswerMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homework_answer
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homework_answer
     *
     * @mbg.generated
     */
    int insert(HomeworkAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homework_answer
     *
     * @mbg.generated
     */
    HomeworkAnswer selectByPrimaryKey(Integer id);

}