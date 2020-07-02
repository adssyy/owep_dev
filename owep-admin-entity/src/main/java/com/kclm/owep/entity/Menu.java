package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 菜单
 */
public class Menu implements java.io.Serializable {

	private Integer menuId;//id
	private String menuName;//菜单名称
	private String menuDesc;//菜单描述
	private String menuUrl;//菜单地址
	private Integer fatherMenuId;//父级菜单
	private String actionIds;//菜单下的所有行为用“,”分割
	private Set<MenuAction> menuActions = new HashSet<MenuAction>(0);//菜单与行为中间表
	private Set<PerMenu> perMenus = new HashSet<PerMenu>(0);//菜单与权限中间表
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
