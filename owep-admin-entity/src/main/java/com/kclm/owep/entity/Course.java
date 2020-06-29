package com.kclm.owep.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 课程
 */
public class Course implements java.io.Serializable {

	private Integer courseNum;//id
	private String courseSerNum; // 课程编号
	private String courseName;//课程名称
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startTime;//开始时间
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endTime;//结束时间
	private int courseCycle;//课程学时
	private int courseStatus;//课程使用状态	1:启用 2:未启用
	private String courseImage;//课程图片
	private String courseDesc;//课程描述
	private int courseOpenStatus;//视频公开状态	1:公开视频(免费)	2：私有视频(收费)
	private int videoStatus;//是否允许观看	1:允许观看	2:不允许观看，3：依据观看进度限制
	private int hotCourse;//1:表示热门 ，0为不热门
	private String courseType;//课程类型
	private String courseSendType;//课程发送类型，如果些值不为空，则说明是通过远程发送到别的系统
	private CourseItem courseItem;// 课程类别
	private Set<ClazzCourse> clazzCourses = new HashSet<ClazzCourse>(0);//班级与课程中间表
	private Set<PlanmanCourse> planmanCourses = new HashSet<PlanmanCourse>(0);//
	private Set<ClazzQues> clazzQueses = new HashSet<ClazzQues>(0);//方案与课程中间表
	private Set<Chapter> chapters = new HashSet<Chapter>(0);//课程章
	private Set<TeacherCourse> theacherCourses=new HashSet<TeacherCourse>(0);//课程教师
	private Set<CourseComment> courseComments=new HashSet<>(0);//课程评论中的课程id
	private int courseCount;
	private Integer isDelete;//add by lujw 2018/7/19 逻辑删除：1未删除，2删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
