/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:50
 * @version v1.0
 * @description 班级问题
 *
 */
public interface QuestionService {
    /***
     * 增加一条记录
     * @param entity
     * @return
     */
    int save(Question entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    int update(Question entity);

    /***
     * 删除一条记录
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /**
     * 删除多条记录
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);

    /***
     * 查询一条记录
     * @param id
     * @return
     */
    QuestionDTO selectById(Serializable id);

    /***
     * 查询所有
     * @return
     */
    List<QuestionDTO> selectAll();

    /***
     * 根据课程名称来查询
     * @return
     */
    List<QuestionDTO> selectByCourseName(String courseName);

}
