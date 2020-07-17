/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.ProfessionMapper;
import com.kclm.owep.service.ProfessionService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:23
 * @version v1.0
 * @description 专业方向业务层接口
 *
 */
@Service
@Transactional
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private MapperFactory mapperFactory;
    /***
     * 保存专业
     * @param entity
     * @return
     */
    @Override
    public int save(Profession entity) {
        return professionMapper.save(entity);
    }

    /**
     * 更新专业
     * @param entity
     * @return
     */
    @Override
    public int update(Profession entity) {
        return professionMapper.update(entity);
    }

    /**
     * 根据id删除专业
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        return professionMapper.deleteById(id);
    }

    /**
     * 删除多个
     * @param idList
     * @return
     */
    @Override
    public int deleteSelect(List<Serializable> idList) {
        return professionMapper.deleteSelect(idList);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public ProfessionDTO selectById(Serializable id) {
        Profession profession = professionMapper.selectById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(profession,ProfessionDTO.class);
    }

    /**
     * 查找所有
     * @return
     */
    @Override
    public List<ProfessionDTO> selectAll() {
        List<Profession> professions = professionMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(professions,ProfessionDTO.class);
    }

    /**
     * 根据专业名称来查询
     * @param proName
     * @return
     */
    @Override
    public List<ProfessionDTO> selectByProName(String proName) {
        List<Profession> professions = professionMapper.selectByProName(proName);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(professions,ProfessionDTO.class);
    }

    /**
     * 根据所属分支来查询
     * @param branName
     * @return
     */
    @Override
    public List<ProfessionDTO> selectByBranchName(String branName) {
        List<Profession> professions = professionMapper.selectByBranchName(branName);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(professions,ProfessionDTO.class);
    }
}
