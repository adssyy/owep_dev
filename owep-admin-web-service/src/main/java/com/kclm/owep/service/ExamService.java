package com.kclm.owep.service;

import com.kclm.owep.dto.ExamBankDTO;
import com.kclm.owep.dto.ExamPaperDTO;
import com.kclm.owep.dto.ExamQuesDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.vo.ExamPaperVo;

import java.util.List;
import java.util.Map;

public interface ExamService {

    /**
     * 查询所有题库
     */
    List<ExamBankDTO> allExamBank(String name);

    /**
     * 修改题库
     * @param examBank
     * @return
     */
    Map<String, Object> alterBank(ExamBank examBank);

    /**
     * 添加题库
     * @param examBank
     * @param name
     * @return
     */
    Map<String, Object> addBank(ExamBank examBank,String name);

    /**
     * 删除题库
     * @param id
     * @return
     */
    Map<String, Object> deleteBank(int id);

    /**
     * 共享题库
     * @param name
     * @return
     */
    List<ExamBankDTO> shareExamBank(String name);

    /**
     * 所有题库模糊查询
     * @param exam
     * @param name
     * @return
     */
    List<ExamBankDTO> findAllByKeys(ExamBank exam, String name);

    /**
     * 共享题库模糊查询
     * @param exam
     * @param name
     * @return
     */
    List<ExamBankDTO> findShareByKeys(ExamBank exam, String name);

    /**
     * 获取可用题库信息
     * @param name
     * @return
     */
    List<ExamBankDTO> availableExamBank(String name);

    /**
     * 创建试题
     * @param examQues
     * @return
     */
    Map<String, Object> addQues(ExamQues examQues);

    /**
     * 展示所有试题
     * @return
     */
    List<ExamQuesDTO> allQues(String name);

    /**
     * 修改试题
     * @param examQues
     * @return
     */
    Map<String, Object> alterQues(ExamQues examQues);

    /**
     * 模糊查询试题
     * @param ques
     * @return
     */
    List<ExamQuesDTO> selectQuesByKeys(ExamQues ques);

    /**
     * 共享试题
     * @return
     */
    List<ExamQuesDTO> findShareQues();

    /**
     * 添加试卷
     * @param paperVo
     * @return
     */
    Map<String, Object> addPaper(ExamPaperVo paperVo);

    /**
     * 查询所有试卷
     * @param name
     * @return
     */
    List<ExamPaperDTO> findAllPapers(String name);

    /**
     * 根据id查询试卷
     * @param id
     * @param name
     * @return
     */
    List<ExamPaperDTO> findPaperById(Integer id, String name);

    /**
     * 修改试卷
     * @param paperVo
     * @return
     */
    Map<String, Object> alterPaper(ExamPaperVo paperVo);
}
