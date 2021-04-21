package com.kclm.owep.mapper;

import com.kclm.owep.entity.ExamBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamBankMapper {

    List<ExamBank> selectAllByUserType(int id);

    int alterBank(ExamBank examBank);

    int addBank(ExamBank examBank, @Param("userId") int id);

    int deleteBank(int id);

    List<ExamBank> selectShareByUserType(Integer id);

    List<ExamBank> selectAllByKeys(@Param("userId") Integer id, ExamBank exam);

    List<ExamBank> selectShareByKeys(@Param("userId") Integer id, ExamBank exam);

    List<ExamBank> selectAvailableByUserType(Integer id);

    int selectIdByName(String bankName);

    ExamBank selectById(int id);

    List<Integer> shareBankIds();
}
