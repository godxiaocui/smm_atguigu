package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    Emp getEmpByid (@Param("empId") Integer id);
}
