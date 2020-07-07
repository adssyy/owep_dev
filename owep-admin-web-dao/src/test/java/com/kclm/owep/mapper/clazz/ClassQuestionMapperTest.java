package com.kclm.owep.mapper.clazz;

import com.kclm.owep.entity.ClassQuestion;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.ClassQuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClassQuestionMapperTest {

    @Autowired
    private ClassQuestionMapper classQuestionMapper;
    @Test
    void save() {
        ClassQuestion classQuestion = new ClassQuestion();
        classQuestion.setQuestionTitle("java有几种基本类型");
        classQuestion.setStudent(new Student());
        classQuestion.setCourse(new Course());
        classQuestion.setCourseNumber("JAVAEE20200707");
        classQuestion.setCreateTime(LocalDateTime.now());
        classQuestion.setVersion(1);
        classQuestionMapper.save(classQuestion);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteSelect() {
    }

    @Test
    void selectById() {
    }

    @Test
    void selectAll() {
    }
}