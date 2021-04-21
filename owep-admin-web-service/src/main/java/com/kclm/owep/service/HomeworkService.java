/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.HomeworkAnswerDTO;
import com.kclm.owep.dto.HomeworkDTO;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.entity.HomeworkAnswer;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:50
 * @version v1.0
 * @description 班级作业
 *
 */
public interface HomeworkService {
    /***
     * 保存一条记录
     * @param entity
     * @return
     */
    int save(Homework entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    int update(Homework entity);

    /***
     * 根据id来删除一条记录
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /***
     * 删除多条记录
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);

    /***
     * 根据id来查询一条记录
     * @param id
     * @return
     */
    HomeworkDTO selectById(Serializable id);

    /***
     * 查询所有的记录
     * @return
     */
    List<HomeworkDTO> selectAll();

    List<HomeworkDTO> getAll(Integer classId);
    /***
     * 根据课程名查询
     * @param courseName
     * @return
     */
    List<HomeworkDTO> selectByCourseName(String courseName);


    List<HomeworkAnswerDTO> selectById(Integer classId);

    int updateApproval(HomeworkAnswer homeworkAnswer);

    HomeworkAnswer findById(Integer id);
}
