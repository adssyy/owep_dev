package com.kclm.owep.mapper;

import com.kclm.owep.entity.News;
import java.util.List;

public interface NewsMapper {

    /**
     * 删除所选删除新闻纪录
     * @mbg.generated
     */
    int deleteSelect(List<Integer> idList);

    /**
     * 根据id删除新闻纪录
     * @mbg.generated
     */
    int deleteById(Integer id);

    /**
     * 新增新闻纪录
     * @mbg.generated
     */
    int save(News news);

    /**
     * 根据id查询
     * @mbg.generated
     */
    News selectById(Integer id);

    /**
     * 根据名字查询
     * @mbg.generated
     */
    List<NewsMapper> selectByName(News news);

    /**
     * 更新编辑新闻
     * @mbg.generated
     */
    int update(News news);
}