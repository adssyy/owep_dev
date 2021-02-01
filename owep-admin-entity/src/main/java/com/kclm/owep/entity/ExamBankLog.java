package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamBankLog implements Serializable {

    /*
    * 主键
    * */
    private Integer id;

    /*
    * bank_id （fk）
    * */
    private ExamBank examBank;

    /*
    * 操作人
    * */
    private String userName;

    /*
    * 操作时间
    * */
    private LocalDateTime userTime;
}
