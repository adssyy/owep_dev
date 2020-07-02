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
 * @Description 权限
 */
public class Permissions implements java.io.Serializable {

	private Integer perId;//权限id
	private String perName;//权限名称
	private String perDesc;//权限描述
	private Set<RolePermissions> rolePermissions = new HashSet<RolePermissions>(0);//权限和角色中间表
	private Set<PerMenu> perMenus = new HashSet<PerMenu>(0);//权限和菜单中间表
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
