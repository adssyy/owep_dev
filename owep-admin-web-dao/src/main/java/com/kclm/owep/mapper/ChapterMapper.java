/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Chapter;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ChapterMapper
 *
 */
public interface ChapterMapper {


    /**
     * 查询所有的章
     * @return
     */
    List<Chapter> findAll();

    /**
     * 分页查询部分章
     * @param offset
     * @param limit
     * @return
     */
    List<Chapter> findChapterLimit(int offset, int limit);


    /**
     * 通过章的id来查询章
     * @param id
     * @return
     */
    Chapter findById(Serializable id);

    /**
     * 通过章的id删除章
     * @param id
     */
    void deleteById(Serializable id);

    /**
     * 修改章的信息
     * @param chapter
     */
    void updateByField(Chapter chapter);

    /**
     * 添加章
     * @param chapter
     */
    void saveChapter(Chapter chapter);


}