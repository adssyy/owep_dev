/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.mapper.DbCopyMapper;
import com.kclm.owep.service.DbCopyService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 17:08
 *@Description 数据库备份业务层
 */
@Service
public class DbCopyServiceImpl implements DbCopyService {

    @Autowired
    DbCopyMapper dbCopyMapper;

    @Autowired
    MapperFactory mapperFactory;

    /**
     * 查询所有的数据库备份记录
     * @return
     */
    @Override
    public List<DbCopyDTO> findAll() {
        List<DbCopy> dbCopyList=dbCopyMapper.selectAll();
        MapperFacade mapperFacade=mapperFactory.getMapperFacade();
        List<DbCopyDTO> dbCopyDTOS=mapperFacade.mapAsList(dbCopyList,DbCopyDTO.class);
        return dbCopyDTOS;
    }

    @Override
    public List<DbCopyDTO> findByTime(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int downloadById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteSelect(List<Serializable> idList) {
        return 0;
    }

    @Override
    public int backup() {
        return 0;
    }
}
