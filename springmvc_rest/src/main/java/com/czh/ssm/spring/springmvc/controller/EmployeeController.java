package com.czh.ssm.spring.springmvc.controller;

import com.czh.ssm.spring.springmvc.Dao.EmployeeDao;
import com.czh.ssm.spring.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 *  查询所有员工信息-->/employee-->get
 *  跳转到添加页面 -->/add-->get
 *  新增员工信息-->/employee-->post
 *  跳转到修改页面-->/employee/1-->get
 *  修改员工信息-->/employee-->put
 *  修改员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {
@Autowired
    private EmployeeDao employeeDao;
@GetMapping("/employee")
    public String getAllEmployees(Model model){
    Collection<Employee> employeeList = employeeDao.getAll();
    model.addAttribute("employeeList",employeeList);
    System.out.println(employeeList);
    return "employee_list";
}
@PostMapping("/employee")
    public String addEmployee(Employee employee){
    employeeDao.save(employee);
    // 访问列表功能
    //重定向到列表功能
    return "redirect:/employee";
}
    @GetMapping ("/employee/{id}")
    public String toUpdateEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        // 访问列表功能
        //转发到
        return "employee_update";
    }

    @PutMapping  ("/employee")
    public String updateEmployee(Employee employee) {

        employeeDao.save(employee);
        //重定向到列表功能
        return "redirect:/employee";
    }

    @DeleteMapping   ("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id,Model model) {

       employeeDao.delete(id);
       // 重定向
        return "redirect:/employee";
    }
}
