/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.PollItemDTO;
import com.kclm.owep.entity.PollItem;
import com.kclm.owep.mapper.PollItemMapper;
import com.kclm.owep.service.PollItemService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/14 17:05
 *@Description:考评选项业务层实现类
 ***/
@Service
public class PollItemServiceImpl implements PollItemService {

    @Autowired
    private PollItemMapper pollItemMapper;

    @Autowired
    MapperFactory mapperFactory;

    /***
     * 分页查询所有的考评选项
     * @param page  查询第几页
     * @param pageSize   每页的大小
     * @return
     */
    @Override
    public List<PollItemDTO> findAllPollItem(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PollItem> pollItems = pollItemMapper.selectAll();
        //将List<PollItem> 转换成 List<PollItemDTO>
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        List<PollItemDTO> pollItemDTOS = mapperFacade.mapAsList(pollItems,PollItemDTO.class);
        //
        return pollItemDTOS;
    }

    /***
     * 通过id查询考评选项
    * @param id
     * @return
     */
    @Override
    public PollItemDTO findById(Serializable id) {
        PollItem pollItem = pollItemMapper.selectById(id);
        //将pollItem 转换成 pollTtemDTO
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        PollItemDTO pollItemDTO = mapperFacade.map(pollItem,PollItemDTO.class);
        //
        return pollItemDTO;
    }

    /***
     * 通过关键字查询考评选项
     * @param keyword
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<PollItemDTO> findByKeywords(String keyword,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PollItem> pollItems = pollItemMapper.findByKeywords(keyword);
        //
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        List<PollItemDTO> pollItemDTOS = mapperFacade.mapAsList(pollItems,PollItemDTO.class);
        //
        return pollItemDTOS;
    }

    /***
     * 添加考评选项
     * @param pollItem
     * @return
     */
    @Override
    public int addPollItem(PollItem pollItem) {
        return pollItemMapper.save(pollItem);
    }

    /***
     * 批量删除考评选项
     * @param idList
     * @return
     */
    @Override
    public int deleteSelectPollItem(List<Serializable> idList) {
        return pollItemMapper.deleteSelect(idList);
    }

    /***
     * 更新教师考评选项
     * @param pollItem
     * @return
     */
    @Override
    public int updatePollItem(PollItem pollItem) {
        return pollItemMapper.update(pollItem);
    }

    /***
     * 通过id删除考评选项
     * @param id
     * @return
     */
    @Override
    public int deletePollItem(Serializable id) {
        return pollItemMapper.deleteById(id);
    }
}
