package com.kclm.owep.mapper;

import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceSuffix;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    /**
     * 通过课程名称查询课程
     * @param ResourceName
     * @return
     */

    List<Resource> selectByResourceName(String ResourceName);

    List<Resource> selectByResourceSuffix(String ResourceSuffix);

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

    List<Resource> selectResourceSuffix();

    List<Resource> findByKeyword(String ResourceName);

    List<Resource> selectByClassAndKeyword(@Param("cid") Serializable cid,@Param("name") String name,@Param("resourceType") Serializable resourceType);

    List<Resource> selectByClassId(@Param("cid") Serializable cid);

    int deleteFromClass(@Param("cid") Serializable cid,@Param("rid") Serializable rid);

    int deleteSelectFromClass(Serializable cid,List<Serializable> idList);

    //根据时间， 文件类型，名称选择，

    List<Resource>selectByResourceDTO(@Param("resourceSuffix")String resourceSuffix, @Param("resourceName")String resourceName,
                                      @Param("interviewTimeStart")LocalDateTime interviewTimeStart,@Param("interviewTimeEnd")LocalDateTime interviewTimeEnd );


}
