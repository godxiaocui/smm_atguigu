package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 分布查询第二步
     */

    Dept getEmpAndDeptByStepTwo(@Param("deptid") Integer deptId);
}
