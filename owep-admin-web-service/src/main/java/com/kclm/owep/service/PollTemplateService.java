/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.PollItemDTO;
import com.kclm.owep.dto.PollTemplateDTO;
import com.kclm.owep.entity.PollTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/13 10:10
 *@Description:考评模板业务层接口
 ***/
public interface PollTemplateService {

    /**
     * 查找所有考评
     * @return
     */
    List<PollTemplateDTO> findAllPollTemplate();


    /***
     * 根据关键字查询考评模板
     * @param keyword
     * @return
     */
    List<PollTemplateDTO> findByKeywords(String keyword,int page,int pageSize);
    List<PollTemplate> selectBywords(@Param("keywords") String  keywords);

    /***
     * 获取所有的考评模板
     * @param page
     * @param pageSize
     * @return
     */
    List<PollTemplateDTO> findAllPollTemplates(int page,int pageSize);

    /***
     * 根据id获取考评模板信息
     * @param id
     * @return
     */
    PollTemplateDTO findById(Serializable id);

    /***
     * 添加考评模板
     * @param pollTemplate
     * @return
     */
    int addPollTemplate(PollTemplate pollTemplate);

    /***
     * 批量删除考评模板
     * @param idList
     * @return
     */
    int deleteSelectPollTemplate(List<Serializable> idList);

    /***
     * 修改考评模板
     * @param pollTemplate
     * @return
     */
    int updatePollTemplate(PollTemplate pollTemplate);

    /***
     * 根据id删除考评模板
     * @param id
     * @return
     */
    int deletePollTemplate(Serializable id);

    int activate(Integer id);

    int deactivate(Integer id);

    int setItems(@Param("pollTemplateId")Integer pollTemplateId,@Param("pollItemIds") List<Integer> pollItemIds);
}
