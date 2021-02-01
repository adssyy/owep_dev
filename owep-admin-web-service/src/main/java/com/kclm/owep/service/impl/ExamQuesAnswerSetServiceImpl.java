package com.kclm.owep.service.impl;

import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.mapper.ExamQuesAnswerSetMapper;
import com.kclm.owep.service.ExamQuesAnswerSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuesAnswerSetServiceImpl implements ExamQuesAnswerSetService {
    @Autowired
    ExamQuesAnswerSetMapper examQuesAnswerSetMapper;
    @Override
    public int save(ExamQuesAnswerSet examQuesAnswerSet) {
        return examQuesAnswerSetMapper.save(examQuesAnswerSet);
    }

    @Override
    public List<ExamQuesAnswerSet> selectByQuesId(int quesId) {
        return examQuesAnswerSetMapper.selectAnswerSetbyExamQuesId(quesId);
    }
}
