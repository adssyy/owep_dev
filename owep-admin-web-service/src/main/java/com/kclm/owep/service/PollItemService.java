/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.PollItemDTO;
import com.kclm.owep.entity.PollItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/13 9:47
 *@Description:考评选项业务层接口
 ***/
public interface PollItemService {

    /**
     * 查找所有考评
     * @return
     */
    List<PollItemDTO> findAllPollItem();

    /***
     * 获取所有的考评选项
     * @param page  查询第几页
     * @param pageSize   每页的大小
     * @return
     */
    List<PollItemDTO> findAllPollItem(int page,int pageSize);

    /***
     * 根据id获取考评选项
     * @param id
     * @return
     */
    PollItemDTO findById(Serializable id);

    /***
     * 根据关键字查询考评选项
     * @param keyword
     * @return
     */
    List<PollItemDTO> findByKeywords(String keyword,int page,int pageSize);


    List<PollItem> selectBywords(@Param("keywords") String  keywords);
    /***
     * 添加考评选项
     * @param pollItem
     * @return
     */
    int addPollItem(PollItem pollItem);

    /***
     * 批量删除考评选项
     * @param idList
     * @return
     */
    int deleteSelectPollItem(List<Serializable> idList);


    /***
     * 修改考评选项
     * @param pollItem
     * @return
     */
    int updatePollItem(PollItem pollItem);

    /***
     * 根据id删除考评选项
     * @param id
     * @return
     */
    int deletePollItem(Serializable id);

    int activate(Integer id);

    int deactivate(Integer id);


}
