package com.kclm.owep.service;

import com.kclm.owep.dto.DbCopyDTO;

import java.io.IOException;
import java.util.List;

public interface SystemService {

    List<DbCopyDTO> getAllDbCopies();

    int addDbCopy() throws IOException;

    int deleteDbCopy(DbCopyDTO dbCopyDTO) throws IOException;

}
