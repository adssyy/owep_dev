package com.kclm.owep.mapper;

import com.kclm.owep.entity.Exam;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ExamBankMapper extends BaseMapper<ExamBank> {

    //查看我的题库
    List<ExamBank> selectMyAllBank(Integer id);

    //查看共享题库
    List<ExamBank> selectAllshare();

    //模糊查询我的题库关键字
    List<ExamBank> selectByWord(@Param("word") String word, @Param("status") int status, @Param("security") int security,@Param("userId") int userId);

    //通过id值更新bank_status
        int updateBankStatusbyid(@Param("id") int id,@Param("bankStatus") int bankStatus);

    //修改共享题库
        int updateShareBank(ExamBank examBank);

    //模糊查询共享题库
    List<ExamBank> selectShareBankbyWord(@Param("shareWord")String shareWord,@Param("shareStatus")int shareStatus,@Param("userIdList") List<Integer> userIdList);

    //更新题库的试题数量
    int updateQuesNumber(@Param("id") int id);
}
