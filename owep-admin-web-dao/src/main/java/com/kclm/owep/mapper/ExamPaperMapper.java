package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamPaper;
import com.kclm.owep.entity.ExamPaperTopic;
import com.kclm.owep.entity.vo.PaperVo;
import com.kclm.owep.entity.vo.QuesAneswerSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ExamPaperMapper {
    int addPaper(ExamPaper examPaper);

    int addTopic(ExamPaperTopic examPaperTopic);

    int addQuesSet(QuesAneswerSet quesAneswerSet);

    List<PaperVo> findAllPaper(String name);

    List<PaperVo> findPaperById(Integer id, String name);

    void delQuesById(Integer paperId);

    List<Integer> findTopicById(Integer paperId);

    void delTopicById(@Param("list")List<Integer> ids);

    void delPaperById(Integer paperId);
}
