package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 行为与菜单中间表
 */
public class ClazzResou implements java.io.Serializable {

	private ClazzResouId id;
	private Resoumanage resouManage;
	private Clazz clazz;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
