package com.kclm.owep.dao;

import com.kclm.owep.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/****
 * 持久层接口
 */
@Mapper
public interface UserDao {

    int save(User user);

    int delete(Serializable id);

    int update(User user);

    User findById(Serializable id);

    List<User> findAll();
}
