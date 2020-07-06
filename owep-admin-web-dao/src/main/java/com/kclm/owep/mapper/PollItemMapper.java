/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.mapper;

import com.kclm.owep.entity.PollItem;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:考评选项持久层接口
 ***/
public interface PollItemMapper {

    //添加考评选项
    int save(PollItem pollItem);

    //删除考评选项
    int deleteById(Serializable id);

    //修改考评选项
    int update(PollItem pollItem);

    //通过关键字查找考评选项
    List<PollItem> findByKeywords(@Param("keyword") String keyword);

    //删除多个
    int deleteSelected(List<Integer> idList);

    //统计考评选项数量
    int countPollItem();
}
