/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 用户
 */
public class User implements java.io.Serializable {

	private Integer userId;//用户id
	private String name;//姓名
	private String userPwd;//用户密码
	private String userName;//用户名
	private String userPhone;//用户手机号码
	private String userEmail;//用户邮箱
	private int userSex;//用户性别 1:男   2:女
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime effData;//有效日期
	private int enableStatus;//启用状态  1:启用 2：未启用
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lastTime;//最后登录时间
	private String serNum;//学生/教师编号
	private int userType;//1:表示管理员 2:表示教师 3:表示学生
	private String userImageUrl;//学生图片
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birth;//生日
	private String cardNumber;//身份证号码
	private String userDesc;//用户描述
	private String teacherPosition;//教师职位
	private Integer englishLevel;//学生英语水平
	private Integer education;//学生学历
	private String openid;//微信登陆标识
	private String optionStatus;//是否拥有查看签约未分班学生权限：1有，0没有
	private Integer isDelete;//1:表示未删除 2:表示删除
	private Set<Annount> announts = new HashSet<Annount>(0); // 公告
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);// 关联用户组
	private Set<StudentPaper> studentPapers = new HashSet<StudentPaper>(0);// 学生考卷
	private Set<StudyRecore> studyRecores = new HashSet<StudyRecore>(0);// 学生成绩
	private Set<Teappr> teapprs = new HashSet<Teappr>(0);// 教师考评
	private Set<ClazzQues> clazzQueses = new HashSet<ClazzQues>(0);// 班级问题
	private Set<UserClass> userClazzes = new HashSet<UserClass>(0);// 用户班级
	private Set<Log> logs = new HashSet<Log>(0);// 日志
	private Set<Notes> noteses = new HashSet<Notes>(0);// 笔记
	private Set<ReplyId> replies = new HashSet<ReplyId>(0);// 回复
	private Set<HomeworkAnswer> homeworkAnswers = new HashSet<HomeworkAnswer>(0);// 答案
	private Set<Ltd> ltds = new HashSet<Ltd>(0);//建议咨询
	private Set<NewsInfo> newsInfos = new HashSet<NewsInfo>(0);//新闻资讯
	private Set<TeacherCourse> theacherCourses=new HashSet<TeacherCourse>(0);//课程教师
	private Set<VideoQuestion> videoQuestions=new HashSet<>(0);//视频问题
	private Set<VideoAnswer> videoAnswers=new HashSet<>(0);//回答视屏问题
	private Set<Evaluate> stus=new HashSet<>(0);//教师评价中的学生id
	private Set<Evaluate> teas=new HashSet<>(0);//教师评价中的教师id
	private Set<StuillegalInfo> illegalstus=new HashSet<>(0);//违规信息中的教师id
	private Set<StuillegalInfo> illegalteas=new HashSet<>(0);//违规信息中的教师id
	private Set<CourseComment> courseComments=new HashSet<>(0);//课程评论中的用户ID
	private Set<Message> snedMessages=new HashSet<>(0);//私信消息中发送者的消息id
	private Set<Message> receiveMessages=new HashSet<>(0);//私信消息中接收者的消息id
	private Set<VideoQuesApprove> videoQuesApproves=new HashSet<>();//问题点赞
	private Set<ClientUser> clientUsers;//客户-用户中间表
	private Set<VideoWatchRecord> videoWatchRecords=new HashSet<>();//观看视频绝对记录
	
    private String emailCode;//email状态
    //USERSCHOOL
    private String userSchool;//学校
    //USERCOLLEGE
    private String userCollege;//学院
    //PERFECTSTATUS
    private String perfectStatus;//个人完善状态(null为未完善 1:为已完善)
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
