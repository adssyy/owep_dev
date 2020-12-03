package com.kclm.owep.service;

import com.kclm.owep.dto.StuDTO;
import com.kclm.owep.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    int create(@Param("student") Student student);

    int update(@Param("student") Student student);

    int delete(@Param("id") Integer id);

    List<Student> selectAll();

    List<Integer> getGroupIds(@Param("id") Integer id);

    int setGroups(@Param("studentId") Integer studentId, @Param("groupIds") List<Integer> groupIds);

    StuDTO selectById(@Param("id") Integer id);

//    StuDTO selectByName(String Name);

    StuDTO translator_Stu2StuDto(Student student);
}
