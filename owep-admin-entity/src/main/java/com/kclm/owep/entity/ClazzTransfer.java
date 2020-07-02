package com.kclm.owep.entity;


import java.time.LocalDateTime;

public class ClazzTransfer implements java.io.Serializable {
	private int clazzTranId;//自增id
	private User stuUser;//学生id
	private Clazz oldClass;//原班级
	private Clazz newClass;//转入班级
	private User operUser;//操作人id
	private String clazzDetail;//转班描述
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
