package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoWatchRecord;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:视频观看记录持久层接口
 ***/

public interface VideoWatchRecordMapper {

   /* long countByExample(VideoWatchRecordExample example);


    int deleteByExample(VideoWatchRecordExample example);*/


    int deleteByPrimaryKey(Integer id);


    int insert(VideoWatchRecord record);


    int insertSelective(VideoWatchRecord record);


//    List<VideoWatchRecord> selectByExample(VideoWatchRecordExample example);


    VideoWatchRecord selectByPrimaryKey(Integer id);


   /* int updateByExampleSelective(@Param("record") VideoWatchRecord record, @Param("example") VideoWatchRecordExample example);


    int updateByExample(@Param("record") VideoWatchRecord record, @Param("example") VideoWatchRecordExample example);*/


    int updateByPrimaryKeySelective(VideoWatchRecord record);


    int updateByPrimaryKey(VideoWatchRecord record);
}