package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 教师对学生的评价
 */
public class Evaluate implements java.io.Serializable{

	private int id;//主键
	private User stu;//学生Id
	private User tea;//教师Id
	private String evaluateContent;//评价内容
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

	
}
