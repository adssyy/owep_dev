/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description newsInfo
 */
public class NewsInfo implements java.io.Serializable {

	private int newId;//自增id
	private String newTitle;//新闻标题
	private String newContent;//新闻内容
	private int newType;//新闻类型(1:学员故事 2:新闻资讯)
	private User user;//用户信息
	private String newImgUrl;//新闻图片url
	private Integer newLogoType;//1:表示推荐资讯 2:表示热门资讯
	private int newsCount;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间




}
