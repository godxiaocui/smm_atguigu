package com.czh.ssm.controller.EmployeeController;

import com.czh.ssm.pojo.Emp;
import com.czh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
@GetMapping("/employee")
    // 查找员工信息
    public String getAllEmployees(Model model) {
        List<Emp> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("page", allEmployees);
        // 跳转到列表页面
        return "employee_list";
    }
}
