package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Video;
import com.kclm.owep.mapper.VideoMapper;
import com.kclm.owep.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public int deleteById(Serializable id) {
        final int i = videoMapper.deleteById(id);
        return i;
    }

    @Override
    public int deleteSelect(List<Serializable> idList) {
        return 0;
    }

    @Override
    public Video selectById(Serializable id) {
        return videoMapper.selectById(id);
    }

    @Override
    public int save(Video video) {
        if (video!=null){
            videoMapper.save(video);
            return 1;
        }
        return 0;
    }

    @Override
    public int update(Video video) {
        if (video!=null){
            videoMapper.update(video);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Video> selectAll() {
        return  videoMapper.selectAll();

    }

    @Override
    public Map<String, int[]> weekVideo() {
        return null;
    }

    @Override
    public Video selectByVideoName(String name) {
        return videoMapper.selectByVideoName(name);
    }
}
