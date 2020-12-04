package com.kclm.owep.service;

import com.kclm.owep.dto.StudentDTO;
import com.kclm.owep.entity.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentService {

    /**
     * 根据姓名和学号来查询
     * @param id
     * @param studentNumber
     * @param studentName
     * @return
     */
    List<StudentDTO> selectStudentByKeyword(Serializable id,String studentNumber, String studentName);

    /**
     * 根据班级id来查找学员
     * @param id
     * @return
     */
    List<StudentDTO> selectStudentByClassId(Serializable id);

    /**
     * 删除选中的学生
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);
}
