package com.kclm.owep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OrganizationAndClassDto {

    private Integer id; //组织机构id

    private String OrganizationName; //组织机构名称

    private List<ClassDTO> chileClassList; //子类班级DTO列表
}
