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
     * 分页查询部分章
     * @param offset
     * @param limit
     * @return
     */
    List<Chapter> findChapterLimit(int offset, int limit);


    /**
     * 修改章的信息
     * @param chapter
     */
    void updateByField(Chapter chapter);


}