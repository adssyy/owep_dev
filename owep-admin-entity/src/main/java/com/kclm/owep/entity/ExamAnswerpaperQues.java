package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamAnswerpaperQues implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * answerpaper_id(fk)
    * */
    private ExamAnswerpaper examAnswerpaper;

    /*
    * 试题题干
    * */
    private String quesContent;

    /*
    * (若为选择，判断)问题的选项
    * */
    private String quesChoice;

    /*
    * 判断是否为正确答案(0为错误，1为正确)
    * */
    private Integer quesStatus;

    /*
    * 标准答案的分数
    * */
    private double quesScore;

}
