package com.kclm.owep.mapper;


import com.kclm.owep.entity.Exam;
import com.kclm.owep.entity.ExamPaperTopic;
import com.kclm.owep.entity.ExamQuesHard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExamMapperTest {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private ExamPaperTopicMapper examPaperTopicMapper;
    @Autowired
    private ExamQuesHardMapper examQuesHardMapper;
    @Test
    public void Test1(){
//        ExamPaperTopic examPaperTopic=new ExamPaperTopic();
//        examPaperTopic.setTopicName("选择题");
//        examPaperTopic.setTopicDesc("请选出正确的答案");
//        examPaperTopicMapper.save(examPaperTopic);
        ExamQuesHard examQuesHard=new ExamQuesHard();
        examQuesHard.setHardLevel("变态难");
        examQuesHardMapper.save(examQuesHard);
    }

    @Test
    public void selectAllTest(){
        //examQuesHardMapper.selectAll();
    }

}