/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.kclm.owep.StudyRecordStatisticsDTO;
import com.kclm.owep.dto.StudyRecordDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.StudyRecord;
import com.kclm.owep.mapper.ClazzMapper;
import com.kclm.owep.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************
 *
 * @author tanj
 * @date 2020/6/28 21:46
 * @version v1.0
 * @description 学习进度 的具体功能控制层
 *
 */
@RestController
@RequestMapping("clazz")
public class ClazzStudyProcessController {

    @Autowired
    private StudyRecordService studyRecordService;

    private ClazzMapper clazzMapper;

    @RequestMapping(value = "allStudyRecord",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<StudyRecordStatisticsDTO> selectAll(){

        return this.studyRecordService.selectAll();
    }

    @RequestMapping(value = "selectStudyRecordByKeyword",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<StudyRecordStatisticsDTO> selectByKeyword(String orgName,String branchName, Integer pid, Integer cid){
        System.out.println(orgName);
        return this.studyRecordService.selectByKeyword(orgName,branchName,pid,cid);
    }

}
