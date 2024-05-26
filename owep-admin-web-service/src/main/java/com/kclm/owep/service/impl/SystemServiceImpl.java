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

import java.io.IOException;
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
        log.debug("数据库备份列表实体=============================》》" + dbCopies);
        List<DbCopyDTO> dbCopyDTOs = dbCopyConvert.toDbCopyDTOList(dbCopies);
        log.debug("数据库备份列表============>" + dbCopyDTOs);
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
            log.debug("数据库添加对象=========================》" +backupStatus);
            systemMapper.addDbCopy(backupStatus);
            return 1;
        } else {
            log.debug("数据库添加对象=========================》" +backupStatus);
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
    public int deleteDbCopy(DbCopyDTO dbCopyDTO) throws IOException {
        String filePath = dbCopyDTO.getFilePath();
        String fileName = dbCopyDTO.getFileName();
        Boolean deleteStatus = BackUpSqlUtil.deleteBackupFile(filePath, fileName);
        log.debug("删除数据库备份文件========================》" + filePath + fileName);
        if(deleteStatus == true ){
            int deleteDbCopy = systemMapper.deleteDbCopy(dbCopyDTO.getId());
            log.debug("删除数据库备份信息==========》" + deleteDbCopy);
            if(deleteDbCopy > 0){
                return 1;
            }else{
                return -1;
            }
        }else{
            throw new IOException("删除数据库备份文件失败！");
        }

    }


}
