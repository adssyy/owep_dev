/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/*********************
 * @author: @TODO
 * @version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 公告
 */
public class Annount implements Serializable {

    private Integer releaId;// 公告id
    private int version = 1;  //版本号
    private User user;// 用户
    private String releaTitle;// 公告标题
    private String releaContent;// 公告内容
    private int releaStatus;// 启用状态 1:启用 2:未启用(作废),根据时间判断
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime startTime;// 开始时间
    //	@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime endTime;// 结束时间

    private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
    private int annountCount;//自定义总数

}
