/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 学生成绩
 */
public class StuScore implements java.io.Serializable {

	private Integer stuScoreId;// 学生成绩id
	private StudentPaper studentPaper;// 学生考卷
	private Quesbank paperQuesb;//试卷题目
	private double score;// 分数
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime scortime;// 计分时间
	private String stuAnswer;//学生的答案
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
