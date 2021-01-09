package com.kclm.owep.service;

import com.kclm.owep.entity.ExamBank;

import java.util.List;

public interface ExamBankService {
    //查看全部题库
    List<ExamBank> selectAll();

    //我的题库
    List<ExamBank> selectMyAllBank(int userId);

    //共享题库
    List<ExamBank> selectselectAllshare();

    //更新我的题库
    int updateMyBank(ExamBank examBank);

    //模糊查询我的题库
    List<ExamBank> searchMyBank(String word,int mhstatus,int mhsecurity, int userId);

    //模糊查询共享题库
    List<ExamBank> searchShareBank(String shareWord,int shareStatus,List<Integer> userIdList);

    //通过id值更新bank_status
    int updateBankStatusbyid(int id,int bankStatus);

    //创建题库
    int save(ExamBank examBank);

    //删除题库
    int deletebyid(Integer id);

    //修改共享题库
    int updateShareBank(ExamBank examBank);
}
