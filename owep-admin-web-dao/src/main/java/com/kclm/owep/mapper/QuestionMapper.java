/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */


package com.kclm.owep.mapper;

import com.kclm.owep.entity.Question;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月07日 下午16:10:40
 * @Description 班级问题
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    /***
     * 增加一条记录
     * @param entity
     * @return
     */
    @Override
    int save(Question entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    @Override
    int update(Question entity);

    /***
     * 删除一条记录
     * @param id
     * @return
     */
    @Override
    int deleteById(@Param("id") Serializable id);

    /**
     * 删除多条记录
     * @param idList
     * @return
     */
    @Override
    int deleteSelect(@Param("idList") List<Serializable> idList);

    /***
     * 查询一条记录
     * @param id
     * @return
     */
    @Override
    Question selectById(@Param("id") Serializable id);

    /***
     * 查询所有
     * @return
     */
    @Override
    List<Question> selectAll();

    /***
     * 根据班级id来查询班级问题
     * @return
     */
    List<Question> selectByClassId(@Param("id") Serializable id);

    /***
     * 根据课程id来查询班级问题
     * @param id
     * @return
     */
    List<Question> selectByCourseId(@Param("id") Serializable id);
}