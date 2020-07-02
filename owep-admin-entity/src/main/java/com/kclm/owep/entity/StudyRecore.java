/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description studyRecore
 */
public class StudyRecore implements java.io.Serializable {

	private Integer stCoreId;// 学习记录id
	private Video video;//视屏
	private User user;// 学生（用户）
	private int proindStatus;// 学习进度标识 1:未观看或未观看结束 2:已观看结(只有为2时，才能观看下一个视频)
	private Integer videoRate;// 视频观看进度
	private Integer videoLength;//视频总时长
	private VideoWatchHistory tbVideoWatchHistory;//观看历史
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
