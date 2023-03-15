package com.czh.mybatis;

import com.czh.mybatis.mapper.EmpMapper;
import com.czh.mybatis.pojo.Emp;
import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class MBGTest {
    @Test
    public void testMBG() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        EmpMapper mapper = sqlSessdion.getMapper(EmpMapper.class);
        Emp emp=mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
    @Test
    public void testMBG1() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        EmpMapper mapper = sqlSessdion.getMapper(EmpMapper.class);
        for (int i = 0; i < 30; i++) {
            String name="小明"+i;
            Emp emp = new Emp(null, name, i, "男", 2);
            mapper.insertSelective(emp);
        }

    }
}
