package com.kclm.owep.service.impl;

import com.kclm.owep.dao.UserDao;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/******************
 * @Author yejf
 * @Description TODO
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(Serializable id) {
        return false;
    }

    @Override
    public UserDto findById(Serializable id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        System.out.println("userDao = "+userDao);
        final List<User> all = userDao.findAll();
        //把集合中的User转换成 UserDto 对象
        List<UserDto> results = new ArrayList<>();
        for(User u : all) {
            results.add(new UserDto(u.getId(),u.getUserName(),u.getPassword()));
        }
        //
        return results;
    }
}
