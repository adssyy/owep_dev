package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description homeworkAnswer
 */
public class HomeworkAnswer implements java.io.Serializable {

	private int workAnswerId;//作业答题id
	private String workAnswerContent;//作业答题内容
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime workAnswerTime;//作业答题时间
	private Homework homework;//作业
	private User user;//用户
	private String answerFile;//回答作业上传的附件
	private String answerScore;//教师评分
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间


	
}
