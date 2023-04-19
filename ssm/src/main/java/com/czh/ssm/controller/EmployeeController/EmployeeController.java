package com.czh.ssm.controller.EmployeeController;

import com.czh.ssm.pojo.Emp;
import com.czh.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
//@GetMapping("/employee")
//    // 查找员工信息
//    public String getAllEmployees(Model model) {
//        List<Emp> allEmployees = employeeService.getAllEmployees();
//        model.addAttribute("list", allEmployees);
//        // 跳转到列表页面
//        return "employee_list";
//    }
//分页
    @GetMapping("/employee/page/{pageNum}")
    public String getEmplyoeePage(Model model, @PathVariable("pageNum") Integer pageNum){
        //获取员工分页信息
        PageInfo<Emp> page=employeeService.getAllEmployeesPage(pageNum);
        //将分页信息返回
        model.addAttribute("page",page);
        System.err.println(model);
        return "employee_list";
    }
}
