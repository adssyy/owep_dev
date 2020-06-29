/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;
/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description Systeminfo
 */
public class SystemInfo implements java.io.Serializable {

	private Integer infoId;//自增id
	private String systemName;//系统名称
	private String verInfo;//版本信息
	private String loginImageUrl;//登录图上URL
	private String systemImageUrl;//系统图片URL
	private LocalDateTime createTime;//上传时间
	private int version = 1;  //版本号
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private Integer loginCount;//登录次数
}
