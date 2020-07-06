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
     * 根据名字查询
     * 前端已有bookstrap自带的查询共=功能，但是只能查询页面上显示的记录，无法查询后端的数据
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