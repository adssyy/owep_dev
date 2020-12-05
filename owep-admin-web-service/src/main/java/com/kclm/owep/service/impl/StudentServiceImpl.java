package com.kclm.owep.service.impl;

import com.kclm.owep.dto.StuDTO;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.StudentMapper;
import com.kclm.owep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int create(Student student) {
        student.setCreateTime(LocalDateTime.now());
        try {
            studentMapper.save(student);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(Student student) {
        if(student.getId()==null||studentMapper.selectById(student.getId())==null){
            System.out.println("Id not exist, switch to create.");
            create(student);
            return  1;
        }
        try{
            studentMapper.update(student);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(Integer id) {
        try{
            studentMapper.delete(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> selectAll() {
       List<Student> students=studentMapper.selectAll();
        return students;
    }

    @Override
    public List<Integer> getGroupIds(Integer id) {
        return null;
    }

    @Override
    public int setGroups(Integer studentId, List<Integer> groupIds) {
        return 0;
    }

    @Override
    public StuDTO selectById(Integer id) {
        try{
            Student student=studentMapper.selectById(id);
            StuDTO stuDTO=translator_Stu2StuDto(student);
            return stuDTO;
        }catch ( Exception e){
            return null;
        }
    }


    @Override
    public StuDTO translator_Stu2StuDto(Student student) {
      try{
          StuDTO stuDTO=new StuDTO();
          stuDTO.setId(student.getId());
          stuDTO.setStuName(student.getStuName());
          stuDTO.setStuPassword(student.getStuPwd());
          return stuDTO;
      }catch (Exception e){
          return null;
      }
    }


}
