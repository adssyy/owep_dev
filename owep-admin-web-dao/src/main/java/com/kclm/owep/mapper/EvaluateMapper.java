package com.kclm.owep.mapper;

import com.kclm.owep.entity.Evaluate;

public interface EvaluateMapper {

    /**
    *通过班级id查找学生评价的数据
    */
    Evaluate selectByClassId(Integer classId);
}