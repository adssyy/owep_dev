package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**********
 * 管理员、老师、咨询师用户信息DTO
 */
@Data
@Accessors(chain = true)
public class AllUserDto {

    private Integer id; // 用户ID

    @NotBlank(message = "用户名不能为空")
    private String userName; // 用户名

    @NotBlank(message = "密码不能为空")
    private String userPwd; // 密码

    @NotBlank(message = "姓名不能为空")
    private String realName; // 真实姓名

    @NotBlank(message = "请选择性别")
    private String sex; // 性别  1：男 0：女 -1：未知

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "请输入正确的电话号")
    private String userPhone; // 手机号

    @NotBlank(message = "邮箱不能为空")
    private String userEmail; // 邮箱

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "有效截止日期不能为空")
    private String dueDate; // 过期日期

    private String lastLoginDate; // 上次登录日期

    private Integer status; // 状态

    private String title; // 职称

    private List<List<Integer>> roleIds; //管理员 老师 咨询师等用户拥有的用户组和角色id列表

//    private Integer groupId; // 管理员所属用户组id
//
//    private List<Integer> roleIds; //管理员所拥有的角色id



}
