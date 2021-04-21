package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamQuesMapper {

    int addQues(ExamQues examQues);

    int addQuesAnswer(@Param("id") int quesId,@Param("list") List<ExamQuesAnswerSet> examQuesAnswerSets);

    List<ExamQues> selectAllByUserName(String name);

    int alterQues(ExamQues examQues);

    int alterQuesAnswer(ExamQuesAnswerSet answerSet);

    Integer selectAnswerId(@Param("id") Integer id,@Param("content") String content);

    int delAnswerSet(Integer id);

    List<ExamQues> selectByKeys(ExamQues examQues);

    List<ExamQues> findShareQues(@Param("list") List<Integer> ShareBankIds);

    List<ExamQues> findById(Integer id);
}
