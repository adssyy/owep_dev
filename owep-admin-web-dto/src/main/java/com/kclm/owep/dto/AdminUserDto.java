package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**********
 * 管理员用户信息DTO
 */
@Data
@Accessors(chain = true)
public class AdminUserDto {

    private Integer id; // 管理员用户ID

    private String userName; // 管理员用户名

    private String realName; // 管理员真实姓名

    private String sex; // 管理员性别  1：男 0：女 -1：未知

    private String userPhone; // 管理员手机号

    private String userEmail; // 管理员邮箱

    private String dueDate; // 管理员过期日期

    private String lastLoginDate; // 管理员上次登录日期

    private Integer status; // 管理员状态

}
