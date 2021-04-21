/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.HomeworkAnswer;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 18:06
 * @Description 学员作业完成持久层接口
 */
@Mapper
public interface HomeworkAnswerMapper extends BaseMapper<HomeworkAnswer> {

    /**
     * 根据classId查找
     */
    List<HomeworkAnswer> selectByClassId(Serializable classId);

    List<HomeworkAnswer> selectAllByHomeworkId(Integer homeworkId);

    int updateApproval(HomeworkAnswer homeworkAnswer);

    @Override
    HomeworkAnswer selectById(Serializable id);
}