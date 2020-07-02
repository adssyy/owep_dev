/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 专业课程中间表
 */
public class PlanmanCourse implements java.io.Serializable {

	private PlanmanCourseId id;
	private Course course; // 课程
	private Planmanager planmanager;// 方案
	private Integer stageNum;//阶段编号
	private String stageName;//阶段名称
	private Integer courseOrder;//阶段内课程排序
	private Integer isDelete;//add by lujw逻辑删除：1未删除2删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
