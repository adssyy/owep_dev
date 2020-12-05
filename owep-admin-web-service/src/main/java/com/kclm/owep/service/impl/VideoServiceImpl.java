package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Video;
import com.kclm.owep.mapper.VideoMapper;
import com.kclm.owep.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-30 13:08
 * @description  视频管理业务层实现
 */

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public int deleteById(Serializable id) {

        return videoMapper.deleteById(id);
    }

    @Override
    public int deleteSelect(List<Serializable> idList) {

        return videoMapper.deleteSelect(idList);
    }

    @Override
    public Video selectById(Serializable id) {

        return videoMapper.selectById(id);
    }

    @Override
    public int save(Video video) {
        return videoMapper.save(video);
    }

    @Override
    public int update(Video video) {

        return videoMapper.update(video);
    }

    @Override
    public List<Video> selectAll() {

        return videoMapper.selectAll();
    }
}