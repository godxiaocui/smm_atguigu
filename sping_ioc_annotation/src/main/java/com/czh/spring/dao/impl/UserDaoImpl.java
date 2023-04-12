package com.czh.spring.dao.impl;

import com.czh.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saceUser() {
        System.out.println("保存成功");
    }
}
