package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 * 分配用户组时  用户组和角色id的DTO
 */
@Data
@Accessors(chain = true)
public class GroupRoleRelationDto {

    private Integer parentId; // 父节点  用户组id

    private Integer childId; // 子节点  角色id


}
