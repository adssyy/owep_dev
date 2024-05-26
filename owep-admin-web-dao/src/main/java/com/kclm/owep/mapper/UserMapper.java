package com.kclm.owep.mapper;

import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Role;
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
    List<User> getAdminUser(@Param("adminType") int adminType, @Param("isDelete1") int isDelete1);

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

    /**
     * 批量删除管理员老师等用户
     *
     * @param idList 需要删除的用户ID列表
     * @return 删除的用户数量
     */
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


    /**
     * 根据用户名模糊查询管理员用户信息
     *
     * @param userName 用户名，用于模糊查询
     * @return 管理员用户信息列表
     */
    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByUserName(@Param("userName") String userName);

    /**
     * 根据真实姓名模糊查询管理员用户信息
     *
     * @param realName 真实姓名，用于模糊查询
     * @return 管理员用户信息列表
     */
    @Select("select * from t_user where real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByRealName(@Param("realName") String realName);

    /**
     * 根据用户名和真实姓名模糊查询管理员用户信息
     *
     * @param userName 用户名，用于模糊查询
     * @param realName 真实姓名，用于模糊查询
     * @return 管理员用户信息列表
     */
    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = 0 ")
    List<User> selectAdminUserByUserNameAndRealName(@Param("userName") String userName, @Param("realName") String realName);


    /**
     * 查询所有用户组
     *
     * @return 包含所有用户组信息的List集合
     */
    @Select("select * from t_group")
    List<Group> getAllGroups();

    /**
     * 查询用户组对应的角色列表
     *
     * @param id 用户组ID
     * @return 包含用户组对应角色信息的Role对象列表
     */
    @Select("select * from t_role join t_group_role on t_role.id = t_group_role.role_id where t_group_role.group_id = #{id}")
    List<Role> getRoleListByGroupId(Integer id);

    /**
     * 根据用户id查询用户所属的用户组
     *
     * @param id 用户id
     * @return 包含用户所属用户组信息的Group对象列表
     */
    @Select("select * from t_group join t_user_group on t_group.id = t_user_group.group_id where t_user_group.user_id = #{id}")
    List<Group> getGroupListByUserId(Integer id);

    /**
     * 根据用户组id查询用户所属的角色id列表
     *
     * @param id 用户组id
     * @return 包含用户所属角色id的列表
     */
    @Select("select t_role.id from t_role join t_group_role on t_role.id = t_group_role.role_id where t_group_role.group_id = #{id}")
    List<Integer> getRoleIdListByGroupId(Integer id);

}
