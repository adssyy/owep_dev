package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamQuesMapper extends BaseMapper<ExamQues> {
    //查看我的试题
    List<ExamQues> selectMyQues(String userName);

//    查看共享试题
    List<ExamQues> selectShareQues();

    //导出试题
    List<ExamQues> selectBybankIdAndType(@Param("bankId") int bankId,@Param("typeName") String typeName);
}
