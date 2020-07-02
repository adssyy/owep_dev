package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 组织机构
 */
public class Institu implements java.io.Serializable {

	private Integer insId;// 机构id
	private String instName;// 机构名称
	private int instType;// 机构类型 1:表示学校 2:表示培训中心
	private Set<Childinstitu> childinstitus = new HashSet<Childinstitu>(0);// 机构分支关联
	private Integer isDelete;//逻辑删除 1:表示未删除 2：表示已删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
