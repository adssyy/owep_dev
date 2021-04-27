package com.kclm.owep.service;

import com.kclm.owep.entity.Section;

import java.io.Serializable;

public interface SectionService {

    Section findBySectionId(Serializable id);

    Section findBySectionName(String name);

}
