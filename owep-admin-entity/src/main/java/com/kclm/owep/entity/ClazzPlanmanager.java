package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 班级方案
 */
public class ClazzPlanmanager implements java.io.Serializable {

	private ClazzPlanmanagerId id;
	private Clazz clazz; //班级
	private Planmanager planmanager;// 方案
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
