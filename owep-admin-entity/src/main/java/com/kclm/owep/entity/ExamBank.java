package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamBank implements Serializable {
    /*
     * 主键id
     * */
    private Integer id;

    /*
     * 版本号
     * */
    private Integer version =1;

    /*
     * 创建时间
     * */
    private LocalDateTime createTime=LocalDateTime.now();

    /*
     * 最后一次访问的时间
     * */
    private LocalDateTime lastAccessTime;

    /*
     * 是否逻辑删除，1表示未删除，0表示已删除
     * */
    private Integer isDelete;

    /*
    * user_id (fk)
    * */
    private User user;

    /*
    * 题库名称
    * */
    private String bankName;

    /*
    * 题库状态，0为禁用，1为正常
    * */
    private Integer bankStatus;

    /*
    * 题库说明
    * */
    private String bankDesc;

    /*
    * 访问权限(1为完全私有，2为只读共享)
    * */
    private Integer bankSecurity;

    /*
    * 试题数量
    * */
    private Integer quesNumber;
}
