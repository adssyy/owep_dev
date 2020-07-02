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
 * @Description 专业方向
 */
public class Profe implements java.io.Serializable {

	private Integer profeId;// 专业id
	private String profeName;// 专业名称
	private String profeDesc;// 专业描述
	private int profeStatus;// 启用状态
	private Integer isDelete;//1表示正常 2:表示已删除
	private Set<Clazz> clazzes = new HashSet<Clazz>(0);// 班级
	private Set<ProfeChildinstitu> profeChildinstitus = new HashSet<ProfeChildinstitu>(0);// 分支专业中间表
	private Set<Client> clients = new HashSet<Client>(0);// 客户
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
