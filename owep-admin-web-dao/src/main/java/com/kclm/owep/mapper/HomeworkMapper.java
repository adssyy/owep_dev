/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.mapper;

import com.kclm.owep.entity.Homework;

import java.util.List;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月06日 上午17:40:40
 * @Description 班级作业
 */
public interface HomeworkMapper {

    /***
     * 增加一条记录
     * @param record
     * @return
     */
    int save(Homework record);

    /***
     * 根据id删除一条记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /***
     * 更新一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Homework record);

    /***
     * 根据id查询一条记录
     * @param id
     * @return
     */
    Homework selectByPrimaryKey(Integer id);

    /***
     * 查询所有的记录
     * @return
     */
    List<Homework> selectAll();



}