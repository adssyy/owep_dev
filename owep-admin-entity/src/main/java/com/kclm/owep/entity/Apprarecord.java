/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @author: @TODO
 * @version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 考评记录表
 */
public class Apprarecord implements java.io.Serializable {
	
	private Integer cordId;// 考评记录id
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
	private String ipAddr; // IP地址
	private String cordScore;// 考评得分
	private int optionCount;// 选项条数
	private String cordAdvice;// 考评建议
	private String cordSum;// 考评总分
	private double appra1;//考评选项得分
	private double appra2;//考评选项得分
	private double appra3;//考评选项得分
	private double appra4;//考评选项得分
	private double appra5;//考评选项得分
	private double appra6;//考评选项得分
	private double appra7;//考评选项得分
	private double appra8;//考评选项得分
	private double appra9;//考评选项得分
	private double appra10;//考评选项得分
	private double appra11;//考评选项得分
	private double appra12;//考评选项得分
	private double appra13;//考评选项得分
	private double appra14;//考评选项得分
	private double appra15;//考评选项得分
	private int cordStatus;//状态：1:有效 2:无效
	private Teappr teappr;// 教师考评id

}
