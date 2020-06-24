package com.kclm.owep.dao;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void save() {
        System.out.println("userDao = " + userDao);
        final List<User> all = userDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void findByUserName() {
    }
}