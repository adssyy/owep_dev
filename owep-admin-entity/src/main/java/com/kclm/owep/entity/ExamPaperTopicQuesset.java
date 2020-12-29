package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamPaperTopicQuesset implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * paper_id (fk)
    * */
    private ExamPaper examPaper;

    /*
    * topic_id(fk)
    * */
    private ExamPaperTopic examPaperTopic;

    /*
    * ques_id(fk)
    * */
    private ExamQues examQues;

    /*
    * 试题题干
    * */
    private String quesContent;

    /*
    * 分值
    * */
    private double score;
}
