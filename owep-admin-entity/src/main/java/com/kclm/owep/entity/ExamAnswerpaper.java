package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamAnswerpaper implements Serializable {

    /*
    * 主键ID
    * */
    private Integer id;

    /*
    * 是否已经逻辑删除，1表示未删除，0表示已删除
    * */
    private Integer isDelete;

    /*
    * user_id (fk)
    * */
    private User user;

    /*
    * exam_id(fk)
    * */
    private Exam exam;

    /*
    * 考试名称
    * */
    private String examName;

    /*
    * 试卷名称
    * */
    private String paperName;

    /*
    * 大题名称
    * */
    private String topicName;

    /*
    * 考生答案
    * */
    private String userAnswer;

    /*
    * 标准答案
    * */
    private String quesAnswer;

    /*
    * 考生单题得分
    * */
    private double answerScore;

    /*
    * 单题的总分
    * */
    private double quesScore;

    /*
    * 批改状态（0为未批改，1为已批改）
    * */
    private Integer status;

}
