package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamPaper implements Serializable {
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

    /*该试卷的创建者*/
    private String userName;

    /*
    * 试卷名称
    * */
    private String paperName;

    /*
    * 试卷类型
    * */
    private String paperType;

    /*
    * 试卷状态0为禁用，1为正常
    * */
    private Integer paperStatus;

    /*
    *管理权限（0为完全私有，1为只读共享）
    * */
    private Integer paperSecurity;

    /*
    * 试卷总分
    * */
    private double paperTotal;
}
