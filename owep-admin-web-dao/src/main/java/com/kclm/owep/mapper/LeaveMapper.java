package com.kclm.owep.mapper;

import com.kclm.owep.entity.Evaluate;
import com.kclm.owep.entity.Leave;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveMapper {


    /*
     *通过班级id查找请假处理的数据
     */
    Leave selectByClassId(Integer classId);

    /*
    * 请假审批
    */
    int leaveApproveById(@Param("id") Integer id,@Param("approvalStatus") Integer approvalStatus);
}