package com.kclm.owep.mapper;

import com.kclm.owep.entity.Illegal;

import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IllegalMapper {
    /*
    *根据班级id查询违纪处理的数据
    */
    List<Illegal> selectByClassId(Integer classId);

    /*
    * 通过id删除数据
    * */
    int deleteById(Integer id);

    /*
    * 条件查询
    */
    List<Illegal> selectByCondition(@Param("number") String number, @Param("name") String name,
                          @Param("startTime") LocalDate startTime,@Param("endTime") LocalDate endTime);

    /*
    * 插入数据
    * */
    int insert(Illegal illegal);
}