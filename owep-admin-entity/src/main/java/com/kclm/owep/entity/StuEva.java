/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description stuEva
 */
public class StuEva implements java.io.Serializable {

	//stuEva_ID
	private int stuEvaId;//自增id
	//evaType
	private int evaType;//类型:1:表示每天2：表示每周3：表示每月
	//evaDayNum
	private int evaDayNum;//天数
	//evatTimeBefore
	private String evaTimeBefore;//每天几点之前开始评鉴
	//evaCalTime
	private String evaCalTime;//时间计算
	//evaCalType
	private int evaCalType;//表示时、分：1表示分钟，2表示小时
	//evaUpdateNum
	private int evaUpdateNum;//修改次数
	private int userId;
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
