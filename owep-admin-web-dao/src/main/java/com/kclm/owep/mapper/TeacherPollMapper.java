package com.kclm.owep.mapper;

import com.kclm.owep.entity.TeacherPoll;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:教师考评持久层接口
 ***/
public interface TeacherPollMapper {

    int countTeacherPoll();

    int deleteById(Serializable id);

    int save(TeacherPoll teacherPoll);

    int insertSelective(TeacherPoll teacherPoll);

    int update(TeacherPoll teacherPoll);

    List<TeacherPoll> findByKeywords(@Param("keyword")String keyword);

    int deleteSelected(List<Integer> idList);
}