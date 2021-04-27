package com.kclm.owep.service.impl;

import com.kclm.owep.convert.SectionConvert;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.mapper.ChapterMapper;
import com.kclm.owep.mapper.SectionMapper;
import com.kclm.owep.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Semaphore;


@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<SectionDTO> findSectionsByChapterId(Serializable id) {
        return SectionConvert.INSTANCE.POs2DTOs(sectionMapper.selectAllById(id));
    }

    @Override
    public Chapter findByChapterId(Serializable id) {
        return chapterMapper.selectById(id);
    }

    @Override
    public Chapter findByChapterName(String name) {
        return chapterMapper.findByChapterName(name);
    }


}
