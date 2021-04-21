package com.kclm.owep.service;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Evaluate;
import com.kclm.owep.entity.HomeworkAnswer;
import com.kclm.owep.entity.Illegal;
import com.kclm.owep.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public interface StudentService {
    int create(@Param("student") Student student);

    int update(@Param("student") Student student);

    int delete(@Param("id") Integer id);

    List<Student> selectAll();

    List<Integer> getGroupIds(@Param("id") Integer id);

    int setGroups(@Param("studentId") Integer studentId, @Param("groupIds") List<Integer> groupIds);

    StuDTO selectById(@Param("id") Integer id);

    Student findById(Integer id);

//    StuDTO selectByName(String Name);

    StuDTO translator_Stu2StuDto(Student student);

    /**
     * 根据姓名和学号来查询
     * @param id
     * @param studentNumber
     * @param studentName
     * @return
     */
    List<StudentDTO> selectStudentByKeyword(Serializable id, String studentNumber, String studentName);

    /**
     * 根据班级id来查找学员
     * @param id
     * @return
     */
    List<StudentDTO> selectStudentByClassId(Serializable id);

    int deleteById(Serializable id);

    /**
     * 删除选中的学生
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);

    /**
     * 查找所有学生信息
     * @return
     */
    List<StudentDTO> findAllStudent();
    List<StudentDTO> selectIllegalStudent(Integer id);

    //通过学号,姓名，开始时间，结束时间查询违纪学生
    List<IllegalDTO> selectStudentByField(String stuNumber, String stuName,
                                          LocalDateTime startTime, LocalDateTime endTime);

    List<EvaluateDTO> findAllEvaluate();

    List<LeaveDTO> studentLeave();

    List<IllegalDTO> studentIllegal(Integer classId);

    /***
     * 更新评价
     * @return
     */
    int updateEvalution(Evaluate evaluate);

    int allowLeaveStatus(Integer id);
    int refuseLeaveStatus(Integer id);

    int addIllegal(Illegal illegal);

}
