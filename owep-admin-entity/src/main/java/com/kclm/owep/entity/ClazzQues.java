package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 班级问题
 */
public class ClazzQues implements java.io.Serializable {

	private Integer quesId;//问题id
	private Clazz clazz;//班级
	private User user;//用户
	private Course course;//课程
	private String quesTitle;//标题
	private String quesDesc;//描述
	private int quesStatus;//问题状态1：未回复2：已回复
	private Set<ReplyId> replies = new HashSet<ReplyId>(0);//回复表
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
