package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 课程类别
 */
public class CourseItem implements Serializable{
	private Integer courseItemId;// 课程类别id
	private String itemName; // 类别名称
	private String itemDesc;// 类别描述
	private Integer patentId;// 父类别id
	private String itemImage;//类别图片
	private Integer isDelete;//add by lujw 添加isDelete变量 做逻辑删除：1未删除，2已删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
