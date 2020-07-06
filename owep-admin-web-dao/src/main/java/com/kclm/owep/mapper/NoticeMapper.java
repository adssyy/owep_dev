package com.kclm.owep.mapper;

import com.kclm.owep.entity.Notice;
import java.util.List;

public interface NoticeMapper {

    /**
     * 删除所选的公告
     * @mbg.generated
     */
    int deleteBySelect(List<Integer> idList);

    /**
     * 根据id删除
     * @mbg.generated
     */
    int deleteById(Integer id);

    /**
     * 新增公告纪录
     * @mbg.generated
     */
    int save(Notice notice);

    /**
     * 根据所选查询
     * @mbg.generated
     */
    List<Notice> selectByName(Notice notice);

    /**
     * 根据id查询公告
     * @mbg.generated
     */
    Notice selectById(Integer id);

    /**
     * 更新公告纪录
     * @mbg.generated
     */
    int update(Notice notice);
}