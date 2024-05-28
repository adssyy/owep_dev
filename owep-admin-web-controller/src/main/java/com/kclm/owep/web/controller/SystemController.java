package com.kclm.owep.web.controller;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.service.SystemService;
import com.kclm.owep.web.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;


    /**
     * 获取数据库备份的信息列表
     *
     * @return 返回包含数据库备份信息列表的R对象
     */
    @PostMapping(value = "/dbcopy-list", produces = "application/json")
    public R getAllDbCopyList() {
        List<DbCopyDTO> dbCopyList = systemService.getAllDbCopies();
        return R.success(dbCopyList);
    }


    /**
     * 添加数据库备份
     *
     * @return 返回添加备份的结果，成功返回R.success()，失败返回R.failure("数据库备份失败！")
     * @throws IOException 抛出IO异常
     */
    @PostMapping(value = "/dbcopy-add", produces = "application/json")
    public R addDbCopy() throws IOException {
        int status = systemService.addDbCopy();
        if (status > 0) {
            return R.success();
        } else {
            return R.failure("数据库备份失败！");
        }
    }

    /**
     * 删除数据库备份信息(单个删除以及批量删除)
     *
     * @param dbCopyDTO 数据库备份信息对象
     * @return 返回删除结果，成功返回R.success()，失败返回R.failure("数据库备份信息删除失败！")
     * @throws IOException 如果删除过程中发生IO异常
     */
    @PostMapping(value = "/dbcopy-delete", produces = "application/json")
    public R deleteDbCopy(@RequestBody List<DbCopyDTO> dbCopyDTO) throws IOException {
        System.out.println("deleteDbCopy: ============================" + dbCopyDTO);
        int deleteStatus = systemService.deleteDbCopy(dbCopyDTO);
        if (deleteStatus > 0) {
            return R.success();
        } else {
            return R.failure("数据库备份信息删除失败！");
        }
    }

    /**
     * 根据开始时间和结束时间查询数据库备份信息列表
     *
     * @param dbCopyDTO 包含开始时间和结束时间的数据库备份DTO对象
     * @return 返回数据库备份信息列表
     */
    @PostMapping(value = "/dbcopy-list-by-time", produces = "application/json")
    public R getDbCopyByTime(DbCopyDTO dbCopyDTO) {
        List<DbCopyDTO> list = systemService.getDbCopyByTime(dbCopyDTO);
        return R.success(list);
    }

    /**
     * 下载数据库备份文件
     *
     * @param dbCopyDTO 包含数据库备份文件信息的DTO对象
     * @param response HttpServletResponse对象，用于将文件写入响应流
     * @param request  HttpServletRequest对象，用于获取请求头信息
     * @throws IOException 抛出IO异常
     */
    @PostMapping(value = "/dbcopy-download", produces = "application/json")
    public void downloadDbCopy(@RequestBody DbCopyDTO dbCopyDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.debug("【dbCopyDTO】===>" + dbCopyDTO.getFilePath()+dbCopyDTO.getFileName());
        systemService.downloadDbCopy(dbCopyDTO, response, request);
    }

}
