package com.kclm.owep.mapper;

import com.kclm.owep.entity.Video;

import java.io.Serializable;
import java.util.List;

import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author zhang_hy
 * @date 2020-11-30 11:43
 * @For 视频管理接口
 */
@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    @Override
    int deleteById(Serializable id);

    @Override
    int deleteSelect(List<Serializable> idList);

    @Override
    Video selectById(Serializable id);

    @Override
    int save(Video video);

    @Override
    int update(Video video);

    Video selectByVideoName(String name);

    @Override
    List<Video> selectAll();
}