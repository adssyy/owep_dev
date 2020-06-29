package com.kclm.owep.entity;
import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 请假条
 */
public class LeaveInfo implements java.io.Serializable {

	private Integer id;//主键
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime leaveStartTime;//离开时间
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime leaveEndTime;//回归时间
	private String leaveReason;//请假事由
	private Integer auditStatus;//审核状态1:未审核、2：已审核、3：已拒绝
	private Integer stuId;//学生Id
	private String opinion;//意见
	private String stuName;//学生姓名
	private String leaveType;//请假类型（病假事假婚假丧假....）
	private int version = 1;  //版本号
	private LocalDateTime createTime = LocalDateTime.now();  //创建时间
	private LocalDateTime lastAccessTime; //最后一次访问时间
}
	
	