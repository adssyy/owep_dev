package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description log
 */
public class Log implements java.io.Serializable {

	private Integer logId;
	private User tbUser;
	private String module;
	private String action;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
