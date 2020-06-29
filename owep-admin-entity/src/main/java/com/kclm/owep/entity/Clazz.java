/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 班级
 */
public class Clazz implements java.io.Serializable {

	private Integer classId;// 班级id
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private Profe profe;// 专业
	private String calssNum;// 班级编号
	private String className;// 班级名称
	private LocalDate startTime;// 开始时间
	private LocalDate endTime;// 结束时间
	private int classStatus;// 状态1:启用、2:未启用
	private String classDesc;// 班级描述
	private Integer isDelete;//1:表示正常 2:表示删除
	private Set<ClazzResou> clazzResous = new HashSet<ClazzResou>(0);// 班级资源
	private Set<ClazzCourse> clazzCourses = new HashSet<ClazzCourse>(0);// 班级课程
	private Set<ClazzPaper> clazzPapers = new HashSet<ClazzPaper>(0);// 班级试卷
	private Set<Teappr> teapprs = new HashSet<Teappr>(0);// 考卷
	private Set<ClazzQues> clazzQues = new HashSet<ClazzQues>(0);// 班级问题
	private Set<ClazzPlanmanager> clazzPlanmanagers = new HashSet<ClazzPlanmanager>(0);// 班级培养方案中间表
	private Set<UserClass> userClasses = new HashSet<UserClass>(0);// 用户班级中间表
	private Set<TeacherCourse> teacherCourses=new HashSet<TeacherCourse>(0);//课程教师
	private Set<Homework> homework=new HashSet<Homework>(0);//作业
}
