package com.kclm.owep.mapper;

import com.kclm.owep.entity.*;
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
     * 更新管理员\咨询师 用户信息
     *
     * @param user 管理员、咨询师用户信息对象
     * @return 更新结果，1表示更新成功，0表示更新失败
     */
    @Update("update t_user set version = version +1, real_name = #{user.realName},  user_phone = #{user.userPhone}, " +
            "gender = #{user.gender}, effective_date = #{user.effectiveDate} where id = #{user.id} and is_delete = #{isDelete1} ")
    int upadteUser(@Param("user") User user,@Param("isDelete1") int isDelete1);



    @Update("update t_user set version = version +1, real_name = #{user.realName},  user_phone = #{user.userPhone}, " +
            "gender = #{user.gender}, effective_date = #{user.effectiveDate}, title = #{user.title}," +
            " status = #{user.status} where id = #{user.id} and is_delete = #{isDelete1} ")
    int upadteTeacherUser(@Param("user") User user,@Param("isDelete1") int isDelete1);

    /**
     * 根据ID查询用户是否存在
     *
     * @param id 用户ID
     * @return 存在则返回User对象，否则返回null
     */
    @Select("select * from t_user where id = #{id} and is_delete = #{isDelete1}")
    User checkUserExistsById(@Param("id") Integer id, @Param("isDelete1") int isDelete1);

    /**
     * 添加管理员用户
     *
     * @param user 管理员用户信息
     * @return 添加结果，成功返回添加的行数，失败返回-1
     */
    @Insert("insert into t_user(user_name, user_pwd, user_phone, real_name, user_email, user_type, gender, status, effective_date, create_time, last_access_time) " +
            " values(#{userName}, #{userPwd}, #{userPhone}, #{realName}, #{userEmail}, #{userType}, #{gender}, #{status}, #{effectiveDate}, now(), now())")
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
    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and is_delete = #{isDelete1} and user_type = #{userType} ")
    List<User> selectAdminUserByUserName(@Param("userName") String userName,@Param("isDelete1") int isDelete1,@Param("userType") int userType);

    /**
     * 根据真实姓名模糊查询管理员用户信息
     *
     * @param realName 真实姓名，用于模糊查询
     * @return 管理员用户信息列表
     */
    @Select("select * from t_user where real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = #{userType} ")
    List<User> selectAdminUserByRealName(@Param("realName") String realName,@Param("isDelete1") int isDelete1,@Param("userType") int userType);

    /**
     * 根据用户名和真实姓名模糊查询管理员用户信息
     *
     * @param userName 用户名，用于模糊查询
     * @param realName 真实姓名，用于模糊查询
     * @return 管理员用户信息列表
     */
    @Select("select * from t_user where user_name like concat('%',#{userName},'%') and real_name like concat('%',#{realName},'%') and is_delete = 1 and user_type = #{userType} ")
    List<User> selectAdminUserByUserNameAndRealName(@Param("userName") String userName, @Param("realName") String realName,@Param("isDelete1") int isDelete1,@Param("userType") int userType);


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
     * 根据用户id和用户组id获取用户对应的角色id
     *
     * @param userId 用户id
     * @param groupId 组id
     * @return 用户对应的角色id列表
     */
    @Select("select role_id from t_user_group where user_id = #{userId} and group_id = #{groupId}")
    List<Integer> getRoleIdByUserIdAndGroupId(@Param("userId") Integer userId,@Param("groupId") Integer groupId);


    /**
     * 查询所有的组织机构
     *
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 包含所有组织机构的列表
     */
    @Select("select * from t_org_institute where is_delete = #{isDelete1}")
    List<OrgInstitute> getAllOrgInstitutes(@Param("isDelete1") Integer isDelete1);

    /**
     * 查询机构对应的班级列表
     *
     * @param instituteName 机构名称
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 包含机构对应班级信息的列表
     */
    @Select("select id, class_name as courseName from t_class where t_class.is_delete = #{isDelete1} and institute_name = #{instituteName}")
    List<Course> getCourseListByOrgName(@Param("instituteName") String instituteName,@Param("isDelete1") Integer isDelete1);


    // TODO  插入用户id和用户组id
    @Insert("insert into t_user_group(user_id, group_id,role_id) values(#{userId}, #{groupId}, #{roleId})")
    int addUserGroup(@Param("userId") Integer userId, @Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

    //TODO

}
