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
 * @Description 学生答卷
 */
public class StudentPaper implements java.io.Serializable {

	private Integer stuPaperId;// 学生答卷id
	private Quesbank quesBank;// 题库
	private User user;// 用户
	private Paper paper;// 试卷
	private String stuAnswer;// 学生答案地址
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endTime;// 交卷时间
	private Set<StuScore> stuScores = new HashSet<StuScore>(0);//
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
