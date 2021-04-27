package com.kclm.owep.service;

import com.kclm.owep.entity.Video;
import com.kclm.owep.entity.vo.SummaryVideo;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhang_hy
 * @date 2020-11-30 13:05
 * @For 视频管理业务层接口
 */
@Service
public interface VideoService {

    int deleteById(Serializable id);

    int deleteSelect(List<Serializable> idList);

    Video selectById(Serializable id);

    int save(Video video);

    int update(Video video);

    List<Video> selectAll();

    Map<String,int[]> weekVideo();

    //
    Video selectByVideoName(String name);

}
