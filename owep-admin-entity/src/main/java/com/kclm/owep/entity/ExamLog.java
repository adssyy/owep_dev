package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamLog implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * exam_id(fk)
    * */
    private Exam exam;

    /*
    * user_id(fk)
    * */
    private User user;

    /*
    * 该用户的开考时间
    * */
    private LocalDateTime userStart;

    /*
    * 该用户的结束时间
    * */
    private LocalDateTime userEnd;

    /*
    * 该用户的ip地址
    * */
    private String userIp;
}
