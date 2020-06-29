package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 意向客户的跟进记录
 */
public class ClientNote implements java.io.Serializable{
	
	private Integer noteId;//跟进记录的自增ID
	private Client client;
	private String clientNote;//跟进记录
	private Integer clientState;//客户类型
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	
}
