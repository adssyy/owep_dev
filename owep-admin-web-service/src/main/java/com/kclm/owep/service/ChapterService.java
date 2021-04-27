package com.kclm.owep.service;

import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Chapter;

import java.io.Serializable;
import java.security.Provider;
import java.util.List;

public interface ChapterService {
    List<SectionDTO> findSectionsByChapterId(Serializable id);

    Chapter findByChapterId(Serializable id);

    Chapter findByChapterName(String name);

}
