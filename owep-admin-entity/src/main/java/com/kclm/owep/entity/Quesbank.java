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
 * @Description 题库
 */
public class Quesbank implements java.io.Serializable {

	private Integer quesbId;// 题库id
	private Section section;// 节
	private String theTitle;// 题目
	private int questype;// 题目类型 1:选择题 2:填空题 3:简答题 4:判断题 5:多选题
	private String titleDesc;// 题目描述
	private int questStatus;// 题目状态 1:启用 2:未启用
	private Set<StudentPaper> studentPapers = new HashSet<StudentPaper>(0);// 学生考卷
	private Set<Option> options = new HashSet<Option>(0);// 选项
	private Set<Answer> answers = new HashSet<Answer>(0);// 答案
	private Set<PaperQuesb> paperQuesbs = new HashSet<PaperQuesb>(0);// 试卷题库中间表
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
