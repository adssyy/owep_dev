package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoCollect;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月07日 上午17:30:40
 * @Description 视频收藏
 */
@Mapper
public interface VideoCollectMapper extends BaseMapper<VideoCollect> {
    /***
     * 添加一条记录
     * @param entity
     * @return
     */
    @Override
    int save(VideoCollect entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    @Override
    int update(VideoCollect entity);

    /***
     * 根据id来删除一条记录
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /***
     * 删除多条记录
     * @param idList
     * @return
     */
    @Override
    int deleteSelect(List<Serializable> idList);

    /***
     * 根据id来查询一条记录
     * @param id
     * @return
     */
    @Override
    VideoCollect selectById(Serializable id);

    /***
     * 查询所有记录
     * @return
     */
    @Override
    List<VideoCollect> selectAll();
}