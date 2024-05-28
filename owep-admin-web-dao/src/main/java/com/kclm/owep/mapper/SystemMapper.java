package com.kclm.owep.mapper;

import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SystemMapper extends BaseMapper {

    /**
     * 查询数据库中t_db_copy表的所有记录
     *
     * @return 包含所有DbCopy对象的列表
     */
    @Select("select * from t_db_copy")
    List<DbCopy> getDbCopies();

    /**
     * 向数据库备份表t_db_copy中插入一条记录
     *
     * @param dbCopy 数据库备份对象，包含文件名、文件路径、状态、创建时间、版本等信息
     * @return 插入的记录数，成功返回1，失败返回0或负数
     */
    @Insert("insert into t_db_copy  set file_name = #{fileName}, file_path = #{filePath}, status = #{status}, " +
            "create_time = #{createTime}, version = #{version}, last_access_time = now() ")
    int addDbCopy(DbCopy dbCopy);


    /**
     * 删除数据库备份数据
     *
     * @param id 备份数据的id
     * @return
     */
    @Delete("delete from t_db_copy where id = #{id}")
    int deleteDbCopy(Integer id);

    /**
     * 根据开始时间查询数据库备份信息
     *
     * @param startTime 开始时间，格式为LocalDateTime类型
     * @return 返回一个DbCopy类型的列表，包含所有开始时间大于等于给定时间的数据库备份信息
     */
    @Select("select * from t_db_copy where create_time >= #{startTime}")
    List<DbCopy> getDbCopiesByStartTime(@Param("startTime") LocalDateTime startTime);

    /**
     * 根据结束时间查询数据库备份信息列表
     *
     * @param endTime 结束时间，类型为LocalDateTime
     * @return 返回数据库备份信息列表，类型为List<DbCopy>
     */
    @Select("select * from t_db_copy where create_time <= #{endTime}")
    List<DbCopy> getDbCopiesByEndTime(@Param("endTime") LocalDateTime endTime);

    /**
     * 根据开始时间和结束时间查询数据库备份信息
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 符合条件的数据库备份信息列表
     */
    @Select("select * from t_db_copy where create_time >= #{startTime} and create_time <= #{endTime}")
    List<DbCopy> getDbCopiesByStartTimeAndEndTime(@Param("startTime") LocalDateTime startTime,@Param("endTime") LocalDateTime endTime);



}
