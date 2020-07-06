package com.kclm.owep.mapper;

import com.kclm.owep.entity.PollRecord;
import java.io.Serializable;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:考评记录持久层接口
 ***/

public interface PollRecordMapper {

    int countPollRecord(PollRecord pollRecord);


    int deleteById(Serializable id);


    int insert(PollRecord record);


    int insertSelective(PollRecord record);


    PollRecord findById(Serializable id);


    int update(PollRecord pollRecord);
}