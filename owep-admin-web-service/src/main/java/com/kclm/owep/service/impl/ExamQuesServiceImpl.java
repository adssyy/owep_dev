package com.kclm.owep.service.impl;

import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.mapper.ExamQuesAnswerSetMapper;
import com.kclm.owep.mapper.ExamQuesMapper;
import com.kclm.owep.service.ExamQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamQuesServiceImpl implements ExamQuesService {
    @Autowired
    private ExamQuesMapper examQuesMapper;
    @Autowired
    private ExamQuesAnswerSetMapper examQuesAnswerSetMapper;
    @Override
    public List<ExamQues> selectMyQues(String userName) {
        return examQuesMapper.selectMyQues(userName);
    }

    @Override
    public List<ExamQues> selectShareQues() {
        return examQuesMapper.selectShareQues();
    }

    @Override
    public List<ExamQuesAnswerSet> selectExamQuesAnswerSet(Integer quesId) {
        return examQuesAnswerSetMapper.selectAnswerSetbyExamQuesId(quesId);
    }

    @Override
    public int saveExamQues(ExamQues examQues) {
        return examQuesMapper.save(examQues);
    }

    @Override
    public List<ExamQues> selectbyBankIdAndtypeName(int bankId, String typeName) {
        return examQuesMapper.selectBybankIdAndType(bankId, typeName);
    }
}
