package com.kclm.owep.mapper;

import com.kclm.owep.entity.SystLog;

import java.time.LocalDateTime;
import java.util.List;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:53
 *@Description 系统日志接口
 */
public interface SystLogMapper {
    /*********
     * 查询所有的日志
     * @return
     */
    List<SystLog> findAll();

    /*********
     * 根据时间或用户名查找日志记录
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    List<SystLog> findByTime(String username, LocalDateTime startTime,LocalDateTime endTime);



}