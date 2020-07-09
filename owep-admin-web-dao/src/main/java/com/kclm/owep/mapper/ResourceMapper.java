/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.mapper.common.BaseMapper;

import java.io.Serializable;
import java.util.List;

/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/6 16:02
 * @Description 文档管理接口
 */
public interface ResourceMapper extends BaseMapper<ResourceMapper> {

    /**
     * 新增文档
     * @param entity
     * @return
     */
    @Override
    int save(ResourceMapper entity);

    /**
     * 更新文档管理记录
     * @param entity
     * @return
     */
    @Override
    int update(ResourceMapper entity);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 根据所选项删除
     * @param idList
     * @return
     */
    @Override
    int deleteSelect(List<Serializable> idList);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    ResourceMapper selectById(Serializable id);

    /**
     * 查询所有记录
     * @return
     */
    @Override
    List<ResourceMapper> selectAll();
}