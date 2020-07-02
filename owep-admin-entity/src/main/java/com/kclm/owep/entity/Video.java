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
 * @Description 节视频
 */
public class Video implements java.io.Serializable {
	
	private Integer videoId;// 视频id
	private Section tbSection;// 节
	private String videoTitle;// 视频标题
	private double videoLen;// 视频时长
	private String videoUrl; // 视频地址
	private int videoStatus;// 视频观看状态 1:允许观看 2:不允许观看
	private String videoDesc;//视频描述
	private String courseSendType;//只作程序判断使用，不作为数据库字段使用
	private Integer sectionId;//只作程序判断使用，不作为数据库字段使用
	private Set<Notes> noteses = new HashSet<Notes>(0);// 课程笔记
	private Set<VideoQuestion> videoQuestions=new HashSet<>(0);//视屏问答
	private Set<StudyRecore> studyRecores = new HashSet<StudyRecore>(0);//学习进度与课程中间表
	private Set<VideoWatchRecord>  videoWatchRecords= new HashSet<>();//观看视频绝对记录
	private Integer isDelete;//add by lujw逻辑删除：1未删除2删除
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	
}
