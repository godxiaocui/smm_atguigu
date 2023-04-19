package com.czh.ssm.service.Impl;

import com.czh.ssm.mapper.EmployeeMapper;
import com.czh.ssm.pojo.Emp;
import com.czh.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public PageInfo<Emp> getAllEmployeesPage(Integer id) {
        // 开启分页功能,第几页。每页限时条数
        PageHelper.startPage(id,6);
        // 查询所有的员工信息
        List<Emp> list = employeeMapper.getAllEmployees();
        // navigatePage是 导航分页页数
        PageInfo<Emp> empPageInfo = new PageInfo<Emp>(list, 5);
        return empPageInfo;
    }
}
