/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */


package com.kclm.owep.mapper;

import com.kclm.owep.entity.ClassQuestion;

import java.util.List;

public interface ClassQuestionMapper {

    /***
     * 增加一条记录
     * @param record
     * @return
     */
    int save(ClassQuestion record);

    /***
     * 根据id删除一条记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(ClassQuestion record);

    /***
     * 根据id查询一条记录
     * @param id
     * @return
     */
    ClassQuestion selectByPrimaryKey(Integer id);

    /***
     * 查询所有的记录
     * @return
     */
    List<ClassQuestion> selectAll();
}