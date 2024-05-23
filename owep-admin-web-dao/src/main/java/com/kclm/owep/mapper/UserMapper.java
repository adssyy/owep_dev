package com.kclm.owep.mapper;

import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /*************
     *
     * @param userName
     * @return
     */
    User selectByName(@Param("userName")String userName );

    List<User> selectByType(@Param("type") Integer type);

    List<Integer> getGroupId(Serializable id);

    int attachGroupToUser( Serializable uid ,  Serializable gid);

    int deleteUserGroupAllocation( Serializable id);

    /**
     * 获取管理员用户列表
     *
     * @return 管理员用户列表
     */
    List<User> getAdminUser();

    /**
     * 更新管理员用户信息
     *
     * @param user 管理员用户信息对象
     * @return 更新结果，1表示更新成功，0表示更新失败
     */
    @Update("update t_user set version = version +1, real_name = #{realName},  user_phone = #{userPhone}, " +
            "gender = #{gender}, effective_date = #{effectiveDate} where id = #{id} and is_delete = 1 ")
    int upadteAdminUser(User user);


    /**
     * 根据ID查询用户是否存在
     *
     * @param id 用户ID
     * @return 存在则返回User对象，否则返回null
     */
    @Select("select * from t_user where id = #{id} and is_delete = 1")
    User checkUserExistsById(Integer id);

    /**
     * 添加管理员用户
     *
     * @param user 管理员用户信息
     * @return 添加结果，成功返回添加的行数，失败返回-1
     */
    @Insert("insert into t_user(user_name, user_phone, real_name, user_email, gender, status, effective_date, create_time, last_access_time) " +
            " values(#{userName}, #{userPhone}, #{realName}, #{userEmail}, #{gender}, 1, #{effectiveDate}, now(), now())")
    int addAdminUser(User user);

    /**
     * 根据用户ID查询用户状态
     *
     * @param id 用户ID
     * @return 用户状态
     */
    @Select("select status from t_user where id = #{id} and is_delete = 1")
    int getUserStatus(Integer id);

    // TODO 批量删除管理员老师等 用户
    @Update({"<script>",
            "update t_user set is_delete = 0, version = version + 1 where id in",
            "<foreach item='item' index='index' collection='idList' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    int deleteSelectedUser(@Param("idList") List<Integer> idList);


    /**
     * 更新用户状态
     * 老师 管理员等状态都调用此方法
     *
     * @param id 用户ID
     * @return 更新结果，1表示更新成功，0表示更新失败
     */
    @Update("update t_user set version = version + 1, status = case when status = 0 then 1 else 0 end where id = #{id}")
    int updateUserStatus(Integer id);


    // TODO  模糊查询
    // TODO  根据用户名查询    根据真实姓名查询   根据用户名和真实姓名一起查询
    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByUserName(@Param("userName") String userName);

    @Select("select * from t_user where real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByRealName(@Param("realName") String realName);

    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByUserNameAndRealName(@Param("userName") String userName, @Param("realName") String realName);
}
