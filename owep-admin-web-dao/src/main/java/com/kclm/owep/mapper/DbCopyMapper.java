package com.kclm.owep.mapper;

import com.kclm.owep.entity.DbCopy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:53
 *@Description 数据库备份接口
 */
public interface DbCopyMapper {

    /***********
     * 查询所有备份记录
     * @return
     */
    List<DbCopy> findAll();

    /***********
     * 根据时间范围查找
     * @param startTime
     * @param endTime
     * @return
     */
    List<DbCopy> findByTime(LocalDateTime startTime,LocalDateTime endTime);

    /************
     * 根据id删除记录
     * @param id
     * @return
     */
    int delete(Serializable id);

    /**********
     * 删除选中的列
     * @param idList
     * @return
     */
    int deleteSelected(List<Integer> idList);
}