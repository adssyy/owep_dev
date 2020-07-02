/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 资源类型
 */
public class ResouType implements java.io.Serializable {

	private Integer resouTypeId;//类型id
	private String resouTypename;//类型名称
	private String resouDesc;//类型描述
	private Integer isDelete;//逻辑删除 1:表示未删除 2：表示已删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
