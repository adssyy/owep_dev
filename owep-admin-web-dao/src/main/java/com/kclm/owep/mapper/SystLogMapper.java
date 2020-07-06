package com.kclm.owep.mapper;

import com.kclm.owep.entity.SystLog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SystLog record);

    int insertSelective(SystLog record);

    SystLog selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(SystLog record);


    int updateByPrimaryKey(SystLog record);
}