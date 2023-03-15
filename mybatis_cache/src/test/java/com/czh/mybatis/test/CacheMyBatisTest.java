package com.czh.mybatis.test;

import com.czh.mybatis.mapper.CacheMapper;
import com.czh.mybatis.pojo.Emp;
import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMyBatisTest {
    /**
     * 测试一级缓存一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就
     * 会从缓存中直接获取，不会从数据库重新访问
     * 使一级缓存失效的四种情况：
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     * @throws IOException
     */
    @Test
    public void TestCacheMybatis() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        CacheMapper mapper = sqlSessdion.getMapper(CacheMapper.class);
        Emp empByID = mapper.getEmpByID(1);
        System.out.println(empByID);
        Emp emp = new Emp(null, "赵日天",23,"男",null);
        mapper.insertEmp(emp);
        Emp empByID2 = mapper.getEmpByID(1);
        System.out.println(empByID2);
        sqlSessdion.close();
        SqlSession sqlSessdion1 = SqlSessionUtils.getSqlSessdion();
        CacheMapper mapper1 = sqlSessdion1.getMapper(CacheMapper.class);
        Emp empByID3 = mapper1.getEmpByID(1);
        System.out.println(empByID3);
    }

    /**
     * 测试二级缓存二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被
     * 缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
     * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * b>在映射文件中设置标签<cache/>
     * 很重要！！！！c>二级缓存必须在SqlSession关闭或提交之后有效
     * 很重要！！！！ d>查询的数据所转换的实体类类型必须实现序列化的接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失
     * @throws IOException
     */
    @Test
    public void TestCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = build.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp empByID = mapper.getEmpByID(1);
        System.out.println(empByID);
        sqlSession1.close();
        SqlSession sqlSession2 = build.openSession(true);
        CacheMapper mapper1 = sqlSession2.getMapper(CacheMapper.class);
        Emp empByID1 = mapper1.getEmpByID(1);
        System.out.println(empByID1);
        sqlSession2.close();

    }
}
