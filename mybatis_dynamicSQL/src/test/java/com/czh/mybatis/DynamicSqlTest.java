package com.czh.mybatis;

import com.czh.mybatis.mapper.DynamicSqlMapper;
import com.czh.mybatis.pojo.Emp;
import com.czh.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
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
}
