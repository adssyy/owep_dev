package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description CourseReport
 */
public class CourseReport implements java.io.Serializable {

	private Integer courseReportId;//统计id
	private Integer videoLearningCount;//已学视屏总数
	private Integer practiceCount;//联系总数
	private Integer notesCount;//笔记数量
	private Integer signCount;//签到次数
	private Integer quesCount;//提问次数
	private Integer homeworkDownCount;//作业完成数
	private Integer answerCount;//回答问题次数
	private Integer testCount;//考试完成数
	private Integer userId;//用户id
	private Integer homeworkCount;//作业总数量
	private Integer courseNum;//课程id
	private Integer videoCount;//视屏总数
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
