package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 用户组-角色中间表
 */
public class GroupRole implements java.io.Serializable {

	private GroupRoleId id;//id
	private Role role;//角色id
	private Group group;//用户组id
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
