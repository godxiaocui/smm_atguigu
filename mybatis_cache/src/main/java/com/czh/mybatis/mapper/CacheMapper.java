package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /***
     *查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByID(@Param("empId") Integer empId);
    /***
     * 添加员工信息
     *
     */
    void insertEmp(@Param("emp") Emp emp);
}
