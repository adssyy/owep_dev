package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoWatchRecord;
import com.kclm.owep.entity.VideoWatchRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoWatchRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    long countByExample(VideoWatchRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int deleteByExample(VideoWatchRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int insert(VideoWatchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int insertSelective(VideoWatchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    List<VideoWatchRecord> selectByExample(VideoWatchRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    VideoWatchRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VideoWatchRecord record, @Param("example") VideoWatchRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VideoWatchRecord record, @Param("example") VideoWatchRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VideoWatchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_videowatch_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VideoWatchRecord record);
}