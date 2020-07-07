package com.kclm.owep.mapper;

import com.kclm.owep.entity.Action;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActionMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Action record);
    int insertSelective(Action record);
    Action selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Action record);
    int updateByPrimaryKey(Action record);
}