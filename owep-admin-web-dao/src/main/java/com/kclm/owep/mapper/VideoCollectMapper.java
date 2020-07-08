package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoCollect;
import com.kclm.owep.entity.VideoCollectExample;
import java.util.List;

import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface VideoCollectMapper extends BaseMapper<VideoCollect> {

    long countByExample(VideoCollectExample example);


    int deleteByExample(VideoCollectExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(VideoCollect record);


    int insertSelective(VideoCollect record);


    List<VideoCollect> selectByExample(VideoCollectExample example);


    VideoCollect selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") VideoCollect record, @Param("example") VideoCollectExample example);


    int updateByExample(@Param("record") VideoCollect record, @Param("example") VideoCollectExample example);


    int updateByPrimaryKeySelective(VideoCollect record);


    int updateByPrimaryKey(VideoCollect record);
}