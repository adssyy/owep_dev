package com.kclm.owep.mapper;

import com.kclm.owep.entity.BranchInstitute;

public interface BranchInstituteMapper {




    int deleteByPrimaryKey(Integer id);


    int insert(BranchInstitute record);


    int insertSelective(BranchInstitute record);


    BranchInstitute selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BranchInstitute record);


    int updateByPrimaryKey(BranchInstitute record);
}