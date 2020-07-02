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
 * @Description 资源管理
 */
public class Resoumanage {

	private Integer resouId;//资源id
	private Section section;//资源所属节
	private String resouName;//资源名称
	private String resouType;//资源类型1:公共资源2:课程资源
	private String resouSize;//资源大小
	private String resouTitle;//资源标题
	private String resouFileurl;//资源文件路径
	private String resouLabel;//资源标签
	private String resouDesc;//资源描述
	private Set<ClazzResou> clazzResous = new HashSet<ClazzResou>(0);//班级资源中间表
	private Integer isDelete;//逻辑删除 1:表示未删除 2：表示已删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	
}
