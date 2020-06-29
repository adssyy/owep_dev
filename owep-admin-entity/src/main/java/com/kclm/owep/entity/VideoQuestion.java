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
 * @Description 视频问题
 */
public class VideoQuestion {

	private Integer videoQuesId;//问题id
	private Video video;//视频
	private User user;//用户
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime videoQuesTime;//提问时间
	private String videoQuesContent;//问题内容
	private Integer quesType;//问题类型，1：问题、2：视频的评论
	private Set<VideoAnswer> videoAnswers=new HashSet<>(0);//问题答案
	private Set<VideoQuesApprove> videoQuesApproves=new HashSet<>();//问题点赞
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
