package com.kclm.owep.service;

import com.kclm.owep.entity.ExamQuesAnswerSet;

import java.util.List;

public interface ExamQuesAnswerSetService {
    //保存
    int save(ExamQuesAnswerSet examQuesAnswerSet);
    //通过quesid获取值
    List<ExamQuesAnswerSet> selectByQuesId(int quesId);
}
