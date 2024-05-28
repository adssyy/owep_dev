package com.kclm.owep.service.impl;

import com.kclm.owep.convert.DbCopyConvert;
import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.mapper.SystemMapper;
import com.kclm.owep.service.SystemService;
import com.kclm.owep.utils.constant.Constant;
import com.kclm.owep.utils.util.BackUpSqlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Autowired
    private DbCopyConvert dbCopyConvert;

    /**
     * 获取数据库备份列表
     *
     * @return 包含所有数据库备份信息的DTO列表
     */
    @Override
    public List<DbCopyDTO> getAllDbCopies() {
        List<DbCopy> dbCopies = systemMapper.getDbCopies();
        log.debug("数据库备份列表实体===>" + dbCopies);
        List<DbCopyDTO> dbCopyDTOs = dbCopyConvert.toDbCopyDTOList(dbCopies);
        log.debug("数据库备份列表===>" + dbCopyDTOs);
        return dbCopyDTOs;
    }

    /**
     * 向数据库中添加数据库备份信息
     *
     * @return 添加成功的返回1，失败的返回-1
     * @throws IOException 如果备份过程中发生IO异常
     */
    @Override
    public int addDbCopy() throws IOException {
        String hostIP = Constant.DB_HOSTIP; // 数据库IP地址
        String userName = Constant.DB_USERNAME; // 数据库用户名
        String password = Constant.DB_PASSWORD; // 数据库密码
        String savePath = Constant.DB_FILEPATH; // 数据库备份文件保存路径
        String databaseName = Constant.DB_DATABASE; // 数据库名称
        System.out.println(hostIP + " =======" + userName + " ===========" + password + "=============== " + savePath + " ============" + databaseName);

        DbCopy backupStatus = BackUpSqlUtil.backUpSql(hostIP, userName, password, savePath, databaseName);
        if (backupStatus.getStatus() == true) {
            log.debug("数据库添加对象===>" + backupStatus);
            systemMapper.addDbCopy(backupStatus);
            return 1;
        } else {
            log.debug("数据库添加对象===>" + backupStatus);
            systemMapper.addDbCopy(backupStatus);
            return -1;
        }
    }

    /**
     * 从数据库中删除指定的备份信息
     *
     * @param dbCopyDTO 数据库备份信息对象，包含备份文件的路径和文件名等信息
     * @return 如果删除成功返回1，否则返回-1
     * @throws IOException 如果删除备份文件失败，则抛出IOException异常
     */
    @Override
    @Transactional
    public int deleteDbCopy(List<DbCopyDTO> dbCopyDTOList) throws IOException {
        int successfulDeletions = 0; // 跟踪成功删除的数量

        for (DbCopyDTO dbCopy : dbCopyDTOList) {
            String filePath = dbCopy.getFilePath();
            String fileName = dbCopy.getFileName();

            try {
                Boolean deleteStatus = BackUpSqlUtil.deleteBackupFile(filePath, fileName);
                log.debug("尝试删除数据库备份文件: " + filePath + fileName);

                if (deleteStatus) {
                    int deleteDbCopyResult = systemMapper.deleteDbCopy(dbCopy.getId());
                    log.debug("删除数据库备份信息结果: " + deleteDbCopyResult);

                    if (deleteDbCopyResult > 0) {
                        successfulDeletions++; // 增加成功删除计数
                    } else {
                        return -1;
                    }
                } else {
                    log.error("删除数据库备份文件失败！");
                    throw new IOException("删除数据库备份文件失败！");
                }
            } catch (IOException e) {
                log.error("在删除过程中发生IO异常", e);
                throw e;
            }
        }
        // 返回成功删除的数量
        return successfulDeletions;
    }

    /**
     * 根据时间获取数据库备份信息
     *
     * @param dbCopyDTO 包含开始时间和结束时间的数据库备份信息DTO对象
     * @return 数据库备份信息DTO对象列表
     * @throws IllegalArgumentException 如果时间范围错误，则抛出该异常
     */
    @Override
    public List<DbCopyDTO> getDbCopyByTime(DbCopyDTO dbCopyDTO) {
        LocalDateTime startTime = dbCopyDTO.getStartTime();
        LocalDateTime endTime = dbCopyDTO.getEndTime();
//        if (startTime == null && endTime == null) {
//            throw new IllegalArgumentException("请选择查询时间");
//        } else
        if (startTime != null && endTime == null) {
            //根据开始时间查询
            List<DbCopy> list = systemMapper.getDbCopiesByStartTime(startTime);
            log.debug("【根据开始时间查询数据库备份信息结果】: " + list);
            List<DbCopyDTO> dbCopyDTOList = dbCopyConvert.toDbCopyDTOList(list);
            log.debug("【根据开始时间查询数据库备份信息的dto结果】: " + dbCopyDTOList);
            return dbCopyDTOList;
        } else if (startTime == null && endTime != null) {
            //根据结束时间查询
            List<DbCopy> list = systemMapper.getDbCopiesByEndTime(endTime);
            log.debug("【根据结束时间查询数据库备份信息结果】: " + list);
            List<DbCopyDTO> dbCopyDTOList = dbCopyConvert.toDbCopyDTOList(list);
            log.debug("【根据结束时间查询数据库备份信息的dto结果】: " + dbCopyDTOList);
            return dbCopyDTOList;
        } else if (startTime != null && endTime != null && startTime.isBefore(endTime)) {
            //根据开始时间和结束时间查询
            List<DbCopy> list = systemMapper.getDbCopiesByStartTimeAndEndTime(startTime, endTime);
            log.debug("【根据开始时间和结束时间查询数据库备份信息结果】: " + list);
            List<DbCopyDTO> dbCopyDTOList = dbCopyConvert.toDbCopyDTOList(list);
            log.debug("【根据开始时间和结束时间查询数据库备份信息的dto结果】: " + dbCopyDTOList);
            return dbCopyDTOList;
        } else if (startTime != null && endTime != null && startTime.isAfter(endTime)) {
            //时间范围错误
            throw new IllegalArgumentException("时间范围错误");
        } else {
            return null;
        }
    }

    /**
     * 下载数据库备份文件
     *
     * @param dbCopyDTO 包含数据库备份文件信息的DTO对象
     * @param response  HttpServletResponse对象，用于将文件写入响应流
     * @param request   HttpServletRequest对象，用于获取请求头信息
     * @throws IOException 抛出IO异常
     */
    @Override
    public void downloadDbCopy(DbCopyDTO dbCopyDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String filePath = dbCopyDTO.getFilePath();
        String fileName = dbCopyDTO.getFileName();
        log.debug("下载数据库备份文件路径: " + filePath + fileName);
        BackUpSqlUtil.downloadDbCopy(filePath, fileName, response, request);

    }


}
