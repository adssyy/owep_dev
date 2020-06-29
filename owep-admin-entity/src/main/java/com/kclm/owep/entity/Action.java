/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @author: @TODO
 * @version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 行为
 */
public class Action implements Serializable {

	private Integer actionId;//id
	private int version = 1;  //版本号
	private String actionName;//行为名称
	private String actionCode;//行为编码
	private String actionUrl;//行为url
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private String actionDesc;//行为描述
	private Set<MenuAction> menuActions = new HashSet<MenuAction>(0);//行为与菜单中间表
}
