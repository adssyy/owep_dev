package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 意向客户
 */
public class Client implements java.io.Serializable{

	private Integer clientId;//意向客户ID
	private String clientName;//意向客户姓名
	private String clientPhone;//意向客户电话
	private Integer clientSex;//性别：1男，2女
	private String clientExperience;//工作经验，或自我介绍
	private String salsemanDescribe;//市场人员对客户的评价
	private Double advancePay;//预付金额
	private Integer isLoan;//是否贷款：1贷款，2未贷款
	//private Integer clientState;//客户状态：1无意向，2已签约，3潜在客户
	private Double totalPay;//总金额
	private Profe profe;//意向专业
	private Integer payment;//还款计划：1表示12个月，2表示24个月，3表示36个月，0表示未贷款
	private Double monthPay;//每月还款金额
	private Integer disclass;//是否分班：1未分班2分班
	private String clientEmail;//用户邮箱
	private Double loan;//贷款金额
	private String interview;//面试时间
	private String major;//专业
	private Set<ClientNote> clientNotes=new HashSet<>();//跟进记录
	private Channel channel;//渠道
	private ClientUser clientUser;//客户-用户中间表
	private ClientState clientState;//客户类型
	private String signTime;//签约时间
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间

}
