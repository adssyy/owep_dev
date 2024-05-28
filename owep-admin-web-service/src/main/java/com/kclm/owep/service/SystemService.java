package com.kclm.owep.service;

import com.kclm.owep.dto.DbCopyDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface SystemService {

    List<DbCopyDTO> getAllDbCopies();

    int addDbCopy() throws IOException;

    int deleteDbCopy(List<DbCopyDTO> dbCopyDTO) throws IOException;

    List<DbCopyDTO> getDbCopyByTime(DbCopyDTO dbCopyDTO);

    void downloadDbCopy(DbCopyDTO dbCopyDTO, HttpServletResponse response, HttpServletRequest request) throws IOException;

}
