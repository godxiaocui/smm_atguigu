package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpByid (@Param("empId") Integer id);
    Emp getEmpByidNew (@Param("empId") Integer id);
    List<Emp> getEmpAndDept(@Param("empId") Integer id);
    // 分布查询
    /**
     * 先查第一个数据
     * 在查第二个数据
     * */
    List<Emp> getEmpAndDeptByStepOne(@Param("empId") Integer id);
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
