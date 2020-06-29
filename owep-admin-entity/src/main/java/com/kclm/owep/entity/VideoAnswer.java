/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;


import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 视频问题答案
 */
public class VideoAnswer {

	private Integer videoAnswerId;//答案id
	private String videoAnswerContent;//答案内容
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime videoAnswerTime;//回答时间
	private VideoQuestion videoQuestion;//视频问题
	private User user;//回答人用户
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
