package com.kclm.owep.mapper;

import com.kclm.owep.entity.TeacherPoll;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:教师考评持久层接口
 ***/

@Mapper
public interface TeacherPollMapper extends BaseMapper<TeacherPoll> {

    int deleteById(Integer id);

    /***
     * 统计教师考评记录数量
     * @return
     */
    int countTeacherPoll();

    /***
     * 根据搜索框条件查询
     * @param className
     * @param teacherName
     * @param profName
     * @return
     */
    List<TeacherPoll> selectByCondition(@Param("className") String className,@Param("profName") String profName,@Param("teacherName") String teacherName);

    //List<TeacherPoll> selectByKeyword(@Param("className") String className,@Param("teacherName") String teacherName,@Param("instituteName") String instituteName,@Param("instituteBranchName") String instituteBranchName,@Param("pid") Serializable pid);
}