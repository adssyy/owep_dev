package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamMemberSet implements Serializable {

    /*
    * 主键
    * */
    private Integer id;

    /*
    * exam_id (fk)
    * */
    private Exam exam;

    /*
    * user_id(fk)
    * */
    private User user;

    /*
    * class_id(fk)
    * */
    private Clazz clazz;
}
