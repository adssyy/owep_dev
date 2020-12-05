package com.kclm.owep.mapper;

import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;


/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/6 16:02
 * @Description 文档管理接口
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    @Override
    int save(Resource resource);

    @Override
    int update(Resource resource);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteSelect(List<Serializable> idList);

    @Override
    Resource selectById(Serializable id);

    @Override
    List<Resource> selectAll();

    List<String> selectResourceSuffix();

    List<Resource> findByKeyword(String keyword);


}