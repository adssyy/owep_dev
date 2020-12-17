package com.kclm.owep.service.impl;

import com.kclm.owep.dto.StuDTO;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.StudentMapper;
import com.kclm.owep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectNoClass() {
        return studentMapper.selectNoClass();
    }

    @Override
    public List<Student> findByKeyword(String keyword) {
        return studentMapper.findByKeyword(keyword);
    }

    @Override
    public int create(Student student) {
        student.setCreateTime(LocalDateTime.now());
        return studentMapper.save(student);
    }

    @Override
    public int update(Student student) {
//        if(student.getId()==null||studentMapper.selectById(student.getId())==null){
//            System.out.println("Id not exist, switch to create.");
//            create(student);
//            return  1;
//        }
//        try{
//            studentMapper.update(student);
//        }catch (Exception e){
//            return 0;
//        }
//        return 1;
        return  studentMapper.update(student);
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
    public List<Student> selectAllSchool() {
        List<Student> students=studentMapper.selectAllSchool();
        return students;
    }

    @Override
    public List<Student> selectAllCollege() {
        List<Student> students=studentMapper.selectAllCollege();
        return students;
    }

    @Override
    public List<Integer> getClassIds(Serializable id) {
        List<Integer> classIds=studentMapper.getClassId(id);
        return classIds;
    }

    @Override
    public int setGroups(Integer studentId, List<Integer> groupIds) {
        return 0;
    }

    @Override
    public Student selectById(Integer id) {
        try{
            Student student=studentMapper.selectById(id);
            //StuDTO stuDTO=translator_Stu2StuDto(student);
            return student;
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

    @Override
    public int insertAllStudent(List<Student> list) {
        int number=0;
        for( Student students:list){
           students.setCreateTime(LocalDateTime.now());
            if(this.studentMapper.save(students)>0);
            number=number+1;
        }
        return number;
    }

    @Override
    public int setClass(Integer stuId, Serializable classIds) {
        return  studentMapper.changeClassId(stuId,classIds);

    }

    @Override
    public int activate(Integer id) {
        try{
            Student student=studentMapper.selectById(id);
            student.setStatus(1);
            studentMapper.update(student);
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deactivate(Integer id) {
        try{
            Student student=studentMapper.selectById(id);
            student.setStatus(0);
            studentMapper.update(student);
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }
}
