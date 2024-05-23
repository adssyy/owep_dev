package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotBlank(message = "姓名不能为空")
    private String realName; // 管理员真实姓名

    private String sex; // 管理员性别  1：男 0：女 -1：未知

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "请输入正确的电话号")
    private String userPhone; // 管理员手机号

    @NotBlank(message = "邮箱不能为空")
    private String userEmail; // 管理员邮箱

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "有效截止日期不能为空")
    private String dueDate; // 管理员过期日期

    private String lastLoginDate; // 管理员上次登录日期

    private Integer status; // 管理员状态

}
