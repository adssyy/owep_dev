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
 * @Description 试卷
 */
public class Paper implements java.io.Serializable {

	private Integer paperId;// 试卷id
	private Course course;// 课程
	private String paperName;// 试卷名称
	private int testlen;// 考试时长
	private Integer choseNum;// 选择题数量
	private Double choseScore;// 选择题分数
	private Integer manyChoseNum;// 多选题数量
	private Double manyChoseScore;// 多选题分数
	private Integer fillNum;// 填空题数量
	private Double fillScore;// 填空题分数
	private Integer shortNum;// 简答题数量
	private Double shortScore;// 简答题分数
	private Integer tfNum;// 判断题数量
	private Double ftScore;// 判断题分数
	private Integer sumScore;// 试卷总分
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime starttime;// 开始时间
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endtime;// 结束时间
	private int paperStatus;// 试卷状态： 1:启用 2:未启用
	private String paperUrl;// 班级试卷url
	private String quesIds;// 问题id集合
	private Set<StudentPaper> studentPapers = new HashSet<StudentPaper>(0);// 学生考卷i
	private Set<PaperQuesb> paperQuesbs = new HashSet<PaperQuesb>(0);// 试卷题库中间表
	private Set<ClazzPaper> clazzPaper = new HashSet<ClazzPaper>(0);// 班级试卷
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
