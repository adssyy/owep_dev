package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserGroupAndRoleDto {

    private Integer id; // 用户组id

    private String groupName; // 用户组名称

    private List<RoleDTO> childRoleList; // 用户组下的角色列表

}
