package com.kclm.owep.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserGroupRoleDto {
    private Integer id;

    private List<GroupRoleRelationDto> groupRoleRelationDtos;

}
