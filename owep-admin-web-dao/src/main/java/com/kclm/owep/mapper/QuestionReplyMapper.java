/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.QuestionReply;

import java.util.List;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月06日 下午16:24:40
 * @Description 班级问题回复表
 */
public interface QuestionReplyMapper {

    /***
     * 增加一条数据
     * @param record
     * @return
     */
    int save(QuestionReply record);

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
    int updateByPrimaryKey(QuestionReply record);

    /***
     * 根据id查询一条记录
     * @param id
     * @return
     */
    QuestionReply selectByPrimaryKey(Integer id);

    /***
     * 查询所有记录
     * @return
     */
    List<QuestionReply> selectAll();


}