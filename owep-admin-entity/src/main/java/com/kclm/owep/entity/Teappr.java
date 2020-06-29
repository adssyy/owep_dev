/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 教师考评
 */
public class Teappr implements java.io.Serializable {

	private Integer teapprId;// 教师考评id
	private Clazz clazz;// 班级表
	private User user;// 用户表
	private Template tbTemplate;// 模板
	private double apprScore;// 考评成绩
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;// 开始时间
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;// 结束时间
	private int teapprStatus;// 考评状态 1:未开始 2:进行中 3:已结束(未审核) 4:已结束(已审核)
	private String auditopin;// 考评地址
	private String allowip;// 允许ip地址
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
