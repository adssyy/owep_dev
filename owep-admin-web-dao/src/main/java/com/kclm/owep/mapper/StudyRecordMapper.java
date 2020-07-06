package com.kclm.owep.mapper;

import com.kclm.owep.entity.StudyRecord;
import java.io.Serializable;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:学习记录持久层接口
 ***/

public interface StudyRecordMapper {

    int countStudyRecord();

    StudyRecord findById(Serializable id);

    int deleteById(Serializable id);


    int save(StudyRecord studyRecord);


    int insertSelective(StudyRecord studyRecord);


    int updateByPrimaryKeySelective(StudyRecord studyRecord);


    int updateByPrimaryKey(StudyRecord studyRecord);
}