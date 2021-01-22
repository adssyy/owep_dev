package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamQuesAnswerSetMapper extends BaseMapper<ExamQuesAnswerSet> {
//    预览试题的答案设置
    List<ExamQuesAnswerSet> selectAnswerSetbyExamQuesId(@Param("quesId") Integer ExamQuesId);
    //保存
    int save(ExamQuesAnswerSet examQuesAnswerSet);
}
