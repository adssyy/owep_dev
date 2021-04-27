package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Section;
import com.kclm.owep.mapper.SectionMapper;
import com.kclm.owep.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    SectionMapper sectionMapper;

    @Override
    public Section findBySectionId(Serializable id) {
        return sectionMapper.selectById(id);
    }

    @Override
    public Section findBySectionName(String name) {
        return sectionMapper.selectBySectionName(name);
    }
}
