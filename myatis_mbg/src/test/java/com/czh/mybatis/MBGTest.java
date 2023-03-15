package com.czh.mybatis;

import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class MBGTest {
    @Test
    public void testMBG() throws IOException {
        SqlSession sqlSessdion = SqlSessionUtils.getSqlSessdion();
        EmpMapper mapper = sqlSessdion.getMapper(EmpMapper.class);
        Emp emp= mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
}
