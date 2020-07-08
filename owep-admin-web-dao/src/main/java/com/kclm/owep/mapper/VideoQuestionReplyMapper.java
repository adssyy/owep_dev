package com.kclm.owep.mapper;

import com.kclm.owep.entity.VideoQuestionReply;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月07日 上午17:30:40
 * @Description 视频问题回复
 */
@Mapper
public interface VideoQuestionReplyMapper extends BaseMapper<VideoQuestionReply> {
    /***
     * 插入一条记录
     * @param entity
     * @return
     */
    @Override
    int save(VideoQuestionReply entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    @Override
    int update(VideoQuestionReply entity);

    /***
     * 根据id删除一条记录
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
    VideoQuestionReply selectById(Serializable id);

    /***
     * 查询所有的 记录
     * @return
     */
    @Override
    List<VideoQuestionReply> selectAll();
}