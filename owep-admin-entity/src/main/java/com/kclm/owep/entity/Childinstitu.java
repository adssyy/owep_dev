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
 * @Description 分支
 */
public class Childinstitu implements java.io.Serializable {

	private Integer chilId; // 学院id（分支id）
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private Institu institu; // 学校（机构）
	private String chileName;// 学院名称（分支名称）
	private Set<ProfeChildinstitu> profeChildinstitus = new HashSet<ProfeChildinstitu>(0);// 分支专业中间表
	private Integer isDelete;//逻辑删除 1:表示未删除 2：表示已删除
}
