package com.kclm.owep.mapper;

import com.kclm.owep.entity.OrgInstitute;

public interface OrgInstituteMapper {


    int deleteByPrimaryKey(Integer id);


    int insert(OrgInstitute record);


    int insertSelective(OrgInstitute record);


    OrgInstitute selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(OrgInstitute record);


    int updateByPrimaryKey(OrgInstitute record);
}