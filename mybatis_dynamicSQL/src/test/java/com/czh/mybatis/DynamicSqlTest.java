package com.czh.mybatis;

import com.czh.mybatis.mapper.DynamicSqlMapper;
import com.czh.mybatis.pojo.Emp;
import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DynamicSqlTest {
    @Test
    public void testDynamicTest() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        DynamicSqlMapper mapper = sqlSessdion.getMapper(DynamicSqlMapper.class);
        char 男 = '男';
        Emp emp1 = new Emp(null, "李四", null, "男", 1, null);
        List<Emp> empByCondition = mapper.getEmpByCondition(emp1);
        System.out.println(empByCondition);
    }
    @Test
    public void TestinsertMoreEmp() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        DynamicSqlMapper mapper = sqlSessdion.getMapper(DynamicSqlMapper.class);
        Emp emp1= new Emp(null, "小米1", null, "男", 1, null);
        Emp emp2= new Emp(null, "小米2", null, "男", 1, null);
        Emp emp3= new Emp(null, "小米3", null, "男", 1, null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);
    }
    @Test
    public void TestdeleteMoreEmp() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        DynamicSqlMapper mapper = sqlSessdion.getMapper(DynamicSqlMapper.class);
        Integer [] emps = new Integer[]{8,9,10};
        mapper.deleteMoreEmp(emps);
    }
}
