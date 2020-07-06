package com.kclm.owep.mapper;

import com.kclm.owep.entity.PollTemplate;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/6 14:07
 *@Description:考评模板持久层接口
 ***/

public interface PollTemplateMapper {

    int countPollTemplate();

    int deleteById(Serializable id);

    int deleteSelected(List<Integer> idList);

    int save(PollTemplate pollTemplate);

    int insertSelective(PollTemplate pollTemplate);

    int update(PollTemplate pollTemplate);

    int updateByPrimaryKeySelective(PollTemplate pollTemplate);

    List<PollTemplate> findByKeywords(@Param("keyword") String keyword);
}