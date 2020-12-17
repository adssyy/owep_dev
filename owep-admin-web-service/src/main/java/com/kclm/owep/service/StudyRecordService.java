package com.kclm.owep.service;

import com.kclm.owep.StudyRecordStatisticsDTO;
import com.kclm.owep.entity.StudyRecord;
import com.kclm.owep.entity.StudyRecordStatistics;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface StudyRecordService {
    int create(@Param("studyRecord") StudyRecord studyRecord);

    int update(@Param("studyRecord") StudyRecord studyRecord);

    int delete(@Param("id") Integer id);

    List<StudyRecordStatisticsDTO> selectAll();

    List<StudyRecordStatisticsDTO> selectByKeyword(String orgName, String branchName, Serializable pid, Serializable cid);

    List<StudyRecordStatisticsDTO> entityToDTO(List<StudyRecordStatistics> studyRecords);
}
