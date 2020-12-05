/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    int save(Resource entity);

    @Override
    int update(Resource entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteSelect(List<Serializable> idList);

    @Override
    Resource selectById(Serializable id);

    @Override
    List<Resource> selectAll();

    List<Resource> selectByClassAndKeyword(@Param("cid") Serializable cid,@Param("name") String name,@Param("resourceType") Serializable resourceType);

    List<Resource> selectByClassId(@Param("cid") Serializable cid);

    int deleteFromClass(@Param("cid") Serializable cid,@Param("rid") Serializable rid);

    int deleteSelectFromClass(Serializable cid,List<Serializable> idList);

    int addToClass(@Param("cid") Serializable cid,@Param("rid") Serializable rid);

    int addSelectToClass(Serializable cid,List<Serializable> idList);

    List<Resource> selectByKeyword(@Param("name") String name, @Param("fileType") String fileType,@Param("beginTime") LocalDateTime beginTime,@Param("endTime") LocalDateTime endTime);
}