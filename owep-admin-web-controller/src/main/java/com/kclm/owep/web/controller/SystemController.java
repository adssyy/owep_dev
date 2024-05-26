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
        if(status > 0){
            return R.success();
        }else{
            return R.failure("数据库备份失败！");
        }
    }

    /**
     * 删除单条数据库备份信息
     *
     * @param dbCopyDTO 数据库备份信息对象
     * @return 返回删除结果，成功返回R.success()，失败返回R.failure("数据库备份信息删除失败！")
     * @throws IOException 如果删除过程中发生IO异常
     */
    @PostMapping(value = "/dbcopy-delete", produces = "application/json")
    public R deleteDbCopy(@RequestBody DbCopyDTO dbCopyDTO) throws IOException {
        System.out.println("deleteDbCopy: ============================" + dbCopyDTO);
        int deleteStatus = systemService.deleteDbCopy(dbCopyDTO);
        if(deleteStatus > 0){
            return R.success();
        }else {
            return R.failure("数据库备份信息删除失败！");
        }
    }


}
