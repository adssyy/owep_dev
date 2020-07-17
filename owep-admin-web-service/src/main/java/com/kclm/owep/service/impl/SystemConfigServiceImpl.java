/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.dto.SystemConfigDTO;
import com.kclm.owep.entity.SystemConfig;
import com.kclm.owep.mapper.SystemConfigMapper;
import com.kclm.owep.service.SystemConfigService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 16:16
 *@Description 系统信息业务层
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    SystemConfigMapper systemConfigMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /**
     * 获取所有系统信息
     * @return
     */
    @Override
    public List<SystemConfigDTO> findAll() {
        List<SystemConfig> systemConfigs=systemConfigMapper.selectAll();
        MapperFacade mapperFacade=mapperFactory.getMapperFacade();
        List<SystemConfigDTO> systemConfigDTOS=mapperFacade.mapAsList(systemConfigs,SystemConfigDTO.class);
        return systemConfigDTOS;
    }

    @Override
    public int save(SystemConfigDTO systemConfigDTO) {
        return 0;
    }
}
