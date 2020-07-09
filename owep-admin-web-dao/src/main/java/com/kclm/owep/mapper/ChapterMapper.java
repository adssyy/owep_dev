/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Chapter;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ChapterMapper
 *
 */
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {


    /**
     * 查询记录数
     * @return
     */
    long rowTotal();

    @Override
    int save(Chapter entity);

    @Override
    int update(Chapter entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteSelect(List<Serializable> idList);

    @Override
    Chapter selectById(Serializable id);

    @Override
    List<Chapter> selectAll();
}