package com.kclm.owep.service;

import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;

import java.util.List;

public interface ExamQuesService {
    //查看我的试题
    List<ExamQues> selectMyQues(String userName);

    //查看共享试题
    List<ExamQues> selectShareQues();

    //查看答案设置
    List<ExamQuesAnswerSet> selectExamQuesAnswerSet(Integer quesId);

    //创建试题
    int saveExamQues(ExamQues examQues);

    //通过bank_id查看typeName的所有行
    List<ExamQues> selectbyBankIdAndtypeName(int bankId,String typeName);
}
