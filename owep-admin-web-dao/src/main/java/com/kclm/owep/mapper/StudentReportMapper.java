/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.StudentReport;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*****
 * @Author
 * @Version v1.0
 * @Create 2020/7/7 16:02
 * @Description 学员学习进度表接口
 */
@Mapper
public interface StudentReportMapper extends BaseMapper<StudentReport> {
    @Override
    int deleteById(@Param("id") Serializable id);

    @Override
    int deleteSelect(@Param("idList") List<Serializable> idList);

    @Override
    StudentReport selectById(@Param("id") Serializable id);
}