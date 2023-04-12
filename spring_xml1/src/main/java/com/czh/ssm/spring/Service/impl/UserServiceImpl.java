package com.czh.ssm.spring.Service.impl;

import com.czh.ssm.spring.Service.UserService;
import com.czh.ssm.spring.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userdao;

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void saveUser() {
        userdao.saveUser();
    }
}
