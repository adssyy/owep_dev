package com.kclm.owep.mapper;


import com.kclm.owep.entity.ExamBank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExamBankMapperTest {

    @Autowired
    ExamBankMapper examBankMapper;
    @Test
    public void selectAll(){
        List<ExamBank> list= examBankMapper.selectAll();

        //
        if (list != null) {
            list.forEach((e) -> {
                System.out.println("题库： "+e);
                System.out.println("所属用户："+e.getUser());
                System.out.println("--------------------------------");
            });
        }
    }
    @Test
    public void selectbyid(){
        System.out.println("===="+examBankMapper);
        ExamBank examBank=examBankMapper.selectById(1);
        System.out.println(examBank);
    }

}