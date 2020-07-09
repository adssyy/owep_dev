package com.kclm.owep.mapper.clazz;

import com.kclm.owep.entity.Question;
import com.kclm.owep.entity.QuestionReply;
import com.kclm.owep.mapper.QuestionReplyMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuestionReplyMapperTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(QuestionReplyMapperTest.class);
    @Autowired
    private QuestionReplyMapper questionReplyMapper;
    @Test
    void save() {
        QuestionReply questionReply = new QuestionReply();
        Question question = new Question();
        question.setId(1);
        questionReply.setQuestion(question);
        questionReply.setReplyContent("在多看几遍视频 ");
        questionReply.setReplyAuthor("yuyan");
        int save = questionReplyMapper.save(questionReply);
        LOGGER.info("{}条记录受影响",save);

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
        QuestionReply questionReply = questionReplyMapper.selectById(1);
        LOGGER.info("{}",questionReply);
    }

    @Test
    void selectAll() {
        List<QuestionReply> questionReplies = questionReplyMapper.selectAll();
        questionReplies.forEach(System.out::println);
    }
}