package com.czh.mybatis.test;

import com.czh.mybatis.mapper.UserMapper;
import com.czh.mybatis.pojo.User;
import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        for (int i = 0; i < 10; i++) {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //不需要写jdbc，所以要写一个替代jdbc的对象，获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //工厂模式，获取 SqlSessionFactory
            SqlSessionFactory SqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
            //创建SqlSession对象，SqlSession是mybatis操作数据库的对象
            // 此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
            //SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
            SqlSession sqlSession = SqlSessionFactory.openSession(true);
//通过代理模式创建UserMapper接口的代理实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
            //映射文件中的SQL标签，并执行标签中的SQL语句
            int j = mapper.insertUser();
            //
            System.out.println(j);
        }

// 修改


    }
    @Test
    // 修改功能
    public void testUpdate() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        int i = mapper.updateUser();
        System.out.println(i);
    }
    @Test
    // 修改功能
    public void deleteUpdate() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        int i = mapper.deleteUser();
        System.out.println(i);
    }

    @Test
    // 修改功能
    public void getUserById() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        User userById = mapper.getUserById();
        System.out.println(userById);
    }

    @Test
    // 修改功能
    public void getUserList() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        UserMapper mapper = sqlSessdion.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User i:userList) {
            System.out.println(i);
        }
    }
}
