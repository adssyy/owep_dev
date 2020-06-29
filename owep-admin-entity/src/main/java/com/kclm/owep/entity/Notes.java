/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description notes
 */
public class Notes implements java.io.Serializable {

	private Integer noteId;// 笔记id
	private User user;// 用户
	private Video video;// 视频
	private String noteContent;// 笔记内容
	private String noteContentText;//笔记纯文本内容
	private Integer noteVidePosition;//笔记在视频中的时间位置记录（秒数）
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
