package com.kclm.owep.mapper;

import com.kclm.owep.entity.vo.SummaryVideo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VideoTest {
    @Autowired
    VideoWatchRecordMapper videoWatchRecordMapper;

    @Test
    public List<SummaryVideo> summaryVideos(){
        return videoWatchRecordMapper.weekRecord();
    }
}
