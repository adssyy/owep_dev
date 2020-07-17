/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.ClassDTO;
import com.kclm.owep.dto.VideoWatchRecordDTO;
import com.kclm.owep.entity.Student;
import com.kclm.owep.entity.StudentReport;
import com.kclm.owep.entity.VideoWatchRecord;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/13 11:29
 *@Description:数据分析模块业务层接口
 ***/
public interface DataAnalysisService {

    /***
     * 分页查询所有的班级
     * @return
     */
    List<ClassDTO> findAllClass(int page, int pageSize);

    /***
     * 通过class_id分页查询出一个班级中所有的学生
     * @return
     */
    List<Student> findAllStudent(Serializable classId,int page,int pageSize);

    /***
     * 根据学员id查询出学员学习报告
     * @param studentId
     * @return
     */
    StudentReport findStudentReport(Serializable studentId);

    /***
     * 通过搜索框条件分页查询出相应的班级
     * @return
     */
    List<ClassDTO> findByCondition(String classNumber,String className,String profName,int page,int pageSize);

    /***
     * 通过id获取相应班级的信息
     * @param id
     * @return
     */
    ClassDTO findById(Serializable id);

    /***
     * 通过用户名查找相应的学员观看记录
     * @param stuName
     * @return
     */
    List<VideoWatchRecordDTO> findByKeywords(String stuName);

    /***
     * 分页查询所有的学员观看记录
     * @param page
     * @param pageSize
     * @return
     */
    List<VideoWatchRecordDTO> findAllVideoWatchRecord(int page,int pageSize);

    /***
     * 通过学生姓名和时间范围查找出相应的学员观看记录
     * @return
     */
    List<VideoWatchRecordDTO> findByNameAndTimeRange();
}
