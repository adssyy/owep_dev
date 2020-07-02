package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 课程评论
 */
public class CourseComment implements java.io.Serializable {

	private int commentId;//id
	private String commentContent;//评论内容
	private User userId;//评论者id
	private Course course;//课程id
	private LocalDateTime commentTime;//评论时间
	private int version = 1;  //版本号
	private LocalDateTime createTime; //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
