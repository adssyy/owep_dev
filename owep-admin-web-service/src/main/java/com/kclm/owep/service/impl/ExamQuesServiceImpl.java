package com.kclm.owep.service.impl;

import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.mapper.ExamQuesMapper;
import com.kclm.owep.service.ExamQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamQuesServiceImpl implements ExamQuesService {
    @Autowired
    private ExamQuesMapper examQuesMapper;
    @Override
    public List<ExamQues> selectMyQues(String userName) {
        return examQuesMapper.selectMyQues(userName);
    }
}
