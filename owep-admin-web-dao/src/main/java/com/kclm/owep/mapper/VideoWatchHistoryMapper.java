package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoWatchHistory;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:视频观看历史持久层接口
 ***/

public interface VideoWatchHistoryMapper {

    int countVideoWatchHistory();


//    int deleteByExample(VideoWatchHistoryExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(VideoWatchHistory record);


    int insertSelective(VideoWatchHistory record);


//    List<VideoWatchHistory> selectByExample(VideoWatchHistoryExample example);


    VideoWatchHistory selectByPrimaryKey(Integer id);


  /*  int updateByExampleSelective(@Param("record") VideoWatchHistory record, @Param("example") VideoWatchHistoryExample example);


    int updateByExample(@Param("record") VideoWatchHistory record, @Param("example") VideoWatchHistoryExample example);*/


    int updateByPrimaryKeySelective(VideoWatchHistory record);


    int updateByPrimaryKey(VideoWatchHistory record);
}