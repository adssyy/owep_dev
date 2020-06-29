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
 * @Description 考评选项
 */
public class Appra implements java.io.Serializable {

	private Integer appraId;// 考评id
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private String appraNum;// 考评编号
	private String appraTitle;// 考评标题
	private int appraStatus;// 考试状态 1:启用 2:未启用
	private double appraScore;// 考评分值
	private Set<TemplateAppra> templateAppras = new HashSet<TemplateAppra>(0);// 模板选项中间表
}
