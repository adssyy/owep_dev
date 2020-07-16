/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/7 16:02
 * @Description 资源类型接口
 */
@Mapper
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {

    /**
     * 根据关键字查询
     * @param keyword
     * @return
     */
    List<ResourceType> findByKeywords(@Param("keyword") String keyword);
}