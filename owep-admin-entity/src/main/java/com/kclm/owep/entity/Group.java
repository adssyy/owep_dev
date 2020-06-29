package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 用户组
 */
public class Group implements java.io.Serializable {

	private Integer groupId;//用户组id
	private String groupName;//用户组名称
	private String groupDesc;//用户组描述
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);//用户组与用户中间表
	private Set<GroupRole> groupRoles = new HashSet<GroupRole>(0);//用户组与角色中间表
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
