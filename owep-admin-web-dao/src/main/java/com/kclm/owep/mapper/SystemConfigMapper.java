package com.kclm.owep.mapper;

import com.kclm.owep.entity.SystemConfig;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:53
 *@Description 系统信息接口
 */
public interface SystemConfigMapper {

    /***********
     * 保存系统信息
     * @param systemConfig
     * @return
     */
    int save(SystemConfig systemConfig);

    /************
     * 更新系统信息
     * @param systemConfig
     * @return
     */
    int update(SystemConfig systemConfig);



}