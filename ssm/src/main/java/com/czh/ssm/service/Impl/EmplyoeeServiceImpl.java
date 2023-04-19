package com.czh.ssm.service.Impl;

import com.czh.ssm.mapper.EmployeeMapper;
import com.czh.ssm.pojo.Emp;
import com.czh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmplyoeeServiceImpl implements EmployeeService {
    @Autowired
private EmployeeMapper employeeMapper;

    public List<Emp> getAllEmployees() {
        System.out.println("!!!");
        return employeeMapper.getAllEmployees();
    }
}
