package com.czh.ssm.spring.dao.Impl;

import com.czh.ssm.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    private UserDao userdao;

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
