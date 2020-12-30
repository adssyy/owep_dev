package com.kclm.owep.mapper;


import com.kclm.owep.entity.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExamMapperTest {
    @Autowired
    private ExamMapper examMapper;
    @Test
    public void Test1(){
        Exam exam=new Exam();
    }
}