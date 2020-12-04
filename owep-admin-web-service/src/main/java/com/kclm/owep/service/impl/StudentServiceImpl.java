package com.kclm.owep.service.impl;

import com.kclm.owep.dto.StudentDTO;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.StudentMapper;
import com.kclm.owep.service.StudentService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<StudentDTO> selectStudentByKeyword(Serializable id,String studentNumber, String studentName) {
        List<Student> students = this.studentMapper.selectByKeyword(id, studentNumber, studentName);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<StudentDTO> studentDTOS = mapperFacade.mapAsList(students, StudentDTO.class);
        return studentDTOS;
    }

    @Override
    public List<StudentDTO> selectStudentByClassId(Serializable id) {
        List<Student> students = this.studentMapper.selectByClassId(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<StudentDTO> studentDTOS = mapperFacade.mapAsList(students, StudentDTO.class);
        return studentDTOS;
    }

    @Override
    public int deleteSelect(List<Serializable> idList){

        return this.studentMapper.deleteSelect(idList);
    }

}
