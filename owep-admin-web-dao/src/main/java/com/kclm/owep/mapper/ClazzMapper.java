/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */


package com.kclm.owep.mapper;

import com.kclm.owep.entity.Clazz;

import java.util.List;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月06日 下午16:10:40
 * @Description 班级
 */
public interface ClazzMapper {

    /***
     * 增加一条记录
     * @param clazz
     * @return
     */
    int save(Clazz clazz);

    /***
     * 根据id删除一条记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /***
     * 更新
     * @param record
     * @return
     */
    int update(Clazz record);

    /***
     * 根据id查询一条记录
     * @param id
     * @return
     */
    Clazz selectByPrimaryKey(Integer id);

    /***
     * 查询全部记录
     * @return
     */
    List<Clazz> selectAll();

    /***
     * 分页查询
     * @param limit
     * @param size
     * @return
     */
    List<Clazz> selectByPage(int limit,int size);

    /***
     * 根据班级编号查询
     * @param number
     * @return
     */
    List<Clazz> selectByNumber(String number);

    /***
     * 根据班级名称来查询
     * @param name
     * @return
     */
    List<Clazz> selectByName(String name);


}