package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description homework
 */
public class Homework implements java.io.Serializable {

	private Integer hwId;// 作业id
	private Section section;// 节
	private String workTitle;// 作业标题
	private String workContent;// 作业内容
	private Clazz clazz;//班级
	private String workFile;//作业文件
	private Set<HomeworkAnswer> homeworkAnswers = new HashSet<HomeworkAnswer>(0);// 答案
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
