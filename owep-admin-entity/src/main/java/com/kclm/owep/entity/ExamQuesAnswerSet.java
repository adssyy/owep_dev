package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamQuesAnswerSet implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * ques_id（fk）
    * */
    private ExamQues examQues;

    /*
    * 试题类型
    * */
    private String typeName;

    /*
    *答案设置的内容
    * */
    private String answerContent;

    /*
    * 判断答案是否正确(0为false，1为true)
    * */
    private Integer answerStatus;
}
