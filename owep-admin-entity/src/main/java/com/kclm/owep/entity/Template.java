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
 * @Description 考评模板
 */
public class Template implements java.io.Serializable {

	private Integer templateId;// 模板id
	private String templateName;// 模板名称
	private int templateCount;// 模板数量
	private String templatEnum;// 模板编号
	private int templateStatus;// 模板状态 1:启用 2:未启用
	private Set<TemplateAppra> templateAppras = new HashSet<TemplateAppra>(0);// 考评模板选项中间表
	private Set<Teappr> teapprs = new HashSet<Teappr>(0);// 教师考评
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
