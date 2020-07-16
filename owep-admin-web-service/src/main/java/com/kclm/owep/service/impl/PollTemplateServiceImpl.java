/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.PollTemplateDTO;
import com.kclm.owep.entity.PollTemplate;
import com.kclm.owep.mapper.PollTemplateMapper;
import com.kclm.owep.service.PollTemplateService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/14 17:51
 *@Description:考评模板业务层实现类
 ***/
@Service
public class PollTemplateServiceImpl implements PollTemplateService {

    @Autowired
    private PollTemplateMapper pollTemplateMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /***
     * 通过关键字分页查询考评模板
     * @param keyword
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<PollTemplateDTO> findByKeywords(String keyword,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PollTemplate> pollTemplates = pollTemplateMapper.findByKeywords(keyword);
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<PollTemplateDTO> pollTemplateDTOs = mapperFacade.mapAsList(pollTemplates,PollTemplateDTO.class);
        //
        return pollTemplateDTOs;
    }

    /***
     * 分页查询所有的考评模板
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<PollTemplateDTO> findAllPollTemplates(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PollTemplate> pollTemplates = pollTemplateMapper.selectAll();
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<PollTemplateDTO> pollTemplateDTOS = mapperFacade.mapAsList(pollTemplates, PollTemplateDTO.class);
        //
        return pollTemplateDTOS;
    }

    /***
     * 通过id查询考评模板
     * @param id
     * @return
     */
    @Override
    public PollTemplateDTO findById(Serializable id) {
        PollTemplate pollTemplate = pollTemplateMapper.selectById(id);
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        PollTemplateDTO pollTemplateDTO = mapperFacade.map(pollTemplate, PollTemplateDTO.class);
        //
        return pollTemplateDTO;
    }

    /***
     * 添加考评模板
     * @param pollTemplate
     * @return
     */
    @Override
    public int addPollTemplate(PollTemplate pollTemplate) {
        return pollTemplateMapper.save(pollTemplate);
    }

    /***
     * 批量删除考评模板
     * @param idList
     * @return
     */
    @Override
    public int deleteSelectPollTemplate(List<Serializable> idList) {
        return pollTemplateMapper.deleteSelect(idList);
    }

    /***
     * 更新考评模板
     * @param pollTemplate
     * @return
     */
    @Override
    public int updatePollTemplate(PollTemplate pollTemplate) {
        return pollTemplateMapper.update(pollTemplate);
    }

    /***
     * 通过id删除考评模板
     * @param id
     * @return
     */
    @Override
    public int deletePollTemplate(Serializable id) {
        return pollTemplateMapper.deleteById(id);
    }
}
