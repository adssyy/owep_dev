package com.kclm.owep.service;

import com.kclm.owep.entity.User;

import java.io.Serializable;
import java.util.List;

/******************
 * 用户持久层
 */
public interface UserService {

    boolean save(User user);

    boolean update(User user);

    boolean delete(Serializable id);

    User findById(Serializable id);

    List<User> findAll();
}
