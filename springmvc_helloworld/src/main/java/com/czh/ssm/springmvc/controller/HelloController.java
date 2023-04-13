package com.czh.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
// @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
// localhost:8080/springMVC/
    @RequestMapping("/")
    public String portal(){
        //设置视图名称,逻辑视图，怎么是逻辑视图，就是物理视图去掉前缀/WEB-INF/templates/和后缀.html
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        //设置视图名称,逻辑视图，怎么是逻辑视图，就是物理视图去掉前缀/WEB-INF/templates/和后缀.html
        return "success";
    }
}
