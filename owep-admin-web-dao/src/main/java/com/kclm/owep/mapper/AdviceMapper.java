package com.kclm.owep.mapper;

import com.kclm.owep.entity.Advice;
import java.util.List;

public interface AdviceMapper {

    /**
     * 根据所选项删除
     * @mbg.generated
     */
    int deleteSelect(List<Integer> idList);

    /**
     * 根据id删除
     * @mbg.generated
     */
    int deleteById(Integer id);

    /**
     * 新增新闻纪录
     * @mbg.generated
     */
    int save(Advice advice);

    /**
     * 根据名字查询
     * @mbg.generated
     */
    List<Advice> selectByName(Advice advice);

    /**
     * 根据id查询
     * @mbg.generated
     */
    Advice selectById(Integer id);

    /**
     * 更新新闻纪录
     * @mbg.generated
     */
    int update(Advice advice);
}