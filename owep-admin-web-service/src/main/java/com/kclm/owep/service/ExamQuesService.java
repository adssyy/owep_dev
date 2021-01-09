package com.kclm.owep.service;

import com.kclm.owep.entity.ExamQues;

import java.util.List;

public interface ExamQuesService {
    //产看我的题库
    List<ExamQues> selectMyQues(String userName);
}
