/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/7 16:02
 * @Description 资源类型接口
 */
@Mapper
public interface ResourceTypeMapper extends BaseMapper<ResourceTypeMapper> {

    /**
     * 新增资源
     * @param entity
     * @return
     */
    @Override
    int save(ResourceTypeMapper entity);

    /**
     * 更新资源记录
     * @param entity
     * @return
     */
    @Override
    int update(ResourceTypeMapper entity);

    /**
     *  根据ID删除
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
     *  根据ID查询
     * @param id
     * @return
     */
    @Override
    ResourceTypeMapper selectById(Serializable id);

    /**
     * 查询所有记录
     * @return
     */
    @Override
    List<ResourceTypeMapper> selectAll();
}