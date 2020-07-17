/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.dto.SystLogDTO;
import com.kclm.owep.entity.SystLog;
import com.kclm.owep.mapper.SystLogMapper;
import com.kclm.owep.service.SystLogService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 16:58
 *@Description 系统日志业务层实现类
 */
@Service
public class SystLogServiceImpl implements SystLogService {

    @Autowired
    private SystLogMapper systLogMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /**
     * 查询所有的日志记录
     * @return
     */
    @Override
    public List<SystLogDTO> findAll() {
        List<SystLog> systLogs=this.systLogMapper.selectAll();
        MapperFacade mapperFacade=mapperFactory.getMapperFacade();
        List<SystLogDTO> systLogDTOS=mapperFacade.mapAsList(systLogs,SystLogDTO.class);
        return systLogDTOS;
    }

    /**
     * 按时间查询日志记录
     * @return
     */
    @Override
    public List<SystLogDTO> findByTime() {
        return null;
    }
}
