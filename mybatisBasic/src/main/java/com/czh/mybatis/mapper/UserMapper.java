package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.User;

import java.util.List;

// 因为后续mybatis会实现方法类，所以并不需要我们创建一一个实例类，只要一个接口就行了
public interface UserMapper {
    public int  insertUser();
    public int  updateUser();

    public int  deleteUser();

    public User getUserById();
    public List<User>getUserList();
}
