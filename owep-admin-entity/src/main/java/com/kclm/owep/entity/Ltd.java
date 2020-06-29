package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 建议咨询
 */
public class Ltd implements java.io.Serializable {

	private Integer ltdID;//自增id
	private Integer ltdType;//信息类型(1:投诉 2:意见 3:建议4:疑问)
	private String ltdSubject;//主题
	private String ltdContent;//内容
	private User user;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	

}
