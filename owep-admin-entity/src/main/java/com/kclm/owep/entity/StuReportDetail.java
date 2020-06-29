/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description stureportDetail
 */
public class StuReportDetail implements java.io.Serializable {

	private Integer stuReportDeaId;
	private String clazzName;
	private String teacher;
	private String school;
	private String college;
	private String teacharge;
	private String counselor;
	private String evaluate;
	private String attend;
	private int userId;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
