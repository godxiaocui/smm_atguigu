package com.czh.ssm.service;

import com.czh.ssm.pojo.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Emp> getAllEmployees();

    PageInfo<Emp> getAllEmployeesPage(Integer id);
}
