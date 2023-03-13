package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Dept;
import com.czh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    /**
     * 分布查询第二步
     */

    Dept getEmpAndDeptByStepTwo(@Param("deptid") Integer deptId);
    Dept getDeptAndEmp(@Param("deptId") Integer deptId);
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
