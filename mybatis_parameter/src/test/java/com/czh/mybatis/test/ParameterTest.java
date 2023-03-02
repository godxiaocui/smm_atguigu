package com.czh.mybatis.test;

import com.czh.mybatis.Utils.SqlSessionUtils;
import com.czh.mybatis.mapper.UserMapper;
import com.czh.mybatis.pojo.User;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class ParameterTest {
    @Test
    public void TestUserByName() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User vbc = mapper.getUserByUsername("ybc");
        System.out.println(vbc);
    }
    @Test
    public void CheckLogin() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User vbc = (User) mapper.CheckLogin("ybc","123");
        System.out.println(vbc);
    }

    @Test
    public void insertUser() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 38, "f", "132123@qq.com");
        mapper.insertUser(user);
    }

    @Test
    public void CheckLoginParam() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User vbc = (User) mapper.CheckLoginParam("ybc","123");
        System.out.println(vbc+"master");
    }
    @Test
    public void CheckLoginParamAgain() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User vbc = (User) mapper.CheckLoginParam("ybc","123");

    }
    @Test
    public void AgainCheckLoginParamAgain() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User vbc = (User) mapper.CheckLoginParam("ybc","123");

    }

}
