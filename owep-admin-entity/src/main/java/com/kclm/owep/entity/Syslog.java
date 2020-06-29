/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description Syslog
 */
public class Syslog implements java.io.Serializable {
	private Integer logId;// 日志id
	private User user;// 用户
	private String title;// 日志主题
	private String ipAddr;// ip地址
	private String method;// 请求方式
	private String reqUrl;// 请求地址
	private int type;// 日志类型 0：web端 1：学生端
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
