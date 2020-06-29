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
 * @Description 章节
 */
public class Section implements java.io.Serializable {

	private Integer secId;//id
	private Chapter chapter;//章
	private String secName;//节名称
	private String secNum;//节编号
	private String secDesc;//节描述
	private int videoStatus;//视频观看状态 1:允许观看 2:不允许观看
	private int videoHave;//此字段和数据库没有关系，只有用于页面判断是否有视频使用
	private Set<Quesbank> quesBanks = new HashSet<Quesbank>(0);//节题库
	private Set<Video> videos = new HashSet<Video>(0);//节视频
	private Set<Homework> homework = new HashSet<Homework>(0);// 作业
	private Integer isDelete;//add by lujw逻辑删除：1未删除2删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
