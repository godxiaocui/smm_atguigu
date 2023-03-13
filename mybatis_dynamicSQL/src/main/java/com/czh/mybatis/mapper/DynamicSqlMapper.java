package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.Emp;

import java.util.List;

public interface DynamicSqlMapper {
    /***
     * 根据条件查询员工信息
     * @param Emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp Emp);

    /***
     * 批量增加员工信息
     * @param emp
     */
    void insertMoreEmp(List<Emp> emp);
}
