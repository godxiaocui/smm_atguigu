package com.czh.spring.service.impl;

import com.czh.spring.dao.UserDao;
import com.czh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
@Qualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public void saveUser() {
        userDao.saceUser();

    }
}
