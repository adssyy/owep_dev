package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamAnswerpaper;
import com.kclm.owep.entity.ExamAnswerpaperQues;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamAnswerpaperQuesMapper extends BaseMapper<ExamAnswerpaperQuesMapper> {
    //只需id，查看全部选项
    public List<ExamAnswerpaperQues> selectbyexamAnserpaperId(int AnswerpaperId);
}
