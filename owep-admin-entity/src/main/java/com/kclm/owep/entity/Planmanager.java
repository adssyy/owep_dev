/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 方案
 */
public class Planmanager implements java.io.Serializable {

	private Integer planId;// 方案id
	private String planNum;// 方案编号
	private String planName;// 方案名称
	private int planStatus;// 启用状态 1:启用 2:未启用
	private Set<PlanmanCourse> planmanCourses = new HashSet<PlanmanCourse>(0);// 方案课程中间表
	private Set<ClazzPlanmanager> clazzPlanmanagers = new HashSet<ClazzPlanmanager>(0);// 班级方案
	private Set<TeacherCourse> tbTeacherCourses=new HashSet<TeacherCourse>(0);//课程教师
	private Integer isDelete;//add by lujw 逻辑删除：1未删除2删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
