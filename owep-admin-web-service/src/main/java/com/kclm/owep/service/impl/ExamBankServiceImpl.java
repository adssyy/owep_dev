package com.kclm.owep.service.impl;

import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.mapper.ExamBankMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.ExamBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamBankServiceImpl implements ExamBankService {
    @Autowired
    private ExamBankMapper examBankMapper;

    @Override
    public List<ExamBank> selectAll() {
        List<ExamBank> list= examBankMapper.selectAll();
        return list;
    }

    @Override
    public List<ExamBank> selectMyAllBank(int userId) {
        return examBankMapper.selectMyAllBank(userId);
    }

    @Override
    public List<ExamBank> selectselectAllshare() {
        return examBankMapper.selectAllshare();
    }

    @Override
    public int updateMyBank(ExamBank examBank) {
        return examBankMapper.update(examBank);
    }

    @Override
    public List<ExamBank> searchMyBank(String word, int mhstatus, int mhsecurity,int userId) {
        return examBankMapper.selectByWord(word, mhstatus, mhsecurity,userId);
    }

    @Override
    public List<ExamBank> searchShareBank(String shareWord, int shareStatus, List<Integer> userIdList) {
        return examBankMapper.selectShareBankbyWord(shareWord,shareStatus,userIdList);
    }

    @Override
    public int updateBankStatusbyid(int id, int bankStatus) {
        return examBankMapper.updateBankStatusbyid(id, bankStatus);
    }

    @Override
    public int save(ExamBank examBank) {
        return examBankMapper.save(examBank);
    }

    @Override
    public int deletebyid(Integer id) {
        return examBankMapper.deleteById(id);
    }

    @Override
    public int updateShareBank(ExamBank examBank) {
        return examBankMapper.updateShareBank(examBank);
    }

    @Override
    public ExamBank selectBankById(Integer id) {
        return examBankMapper.selectById(id);
    }

    @Override
    public int updateQuesNumber(int id) {
        return examBankMapper.updateQuesNumber(id);
    }
}
