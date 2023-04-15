package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping 标识在类上 设置映射请求的请求路径初始信息
 * @RequestMapping 标识在方法设置映射请求的请求路径具体信息
 * 2. @RequestMapping 注解value属性
 *  作用：通过请求的请求路径匹配请求
 *  当前浏览器发送的所有请求路径会匹配value属性中的一个值
 *  method 属性，配置请求方式
 *@RequestMapping的基础上，结合请求方式会有一些派生注解
 * @GetMapping @PostMapping @DeleteMapping@PutMapping
 *
 * 7.@RequestMapping 注解使用路径中的占位符
 * 传统：/ deleteUser?user=1
 * rest /user/delete/1
 * 需要在@RequestMapping 注解中的Value属性设置的路径中，使用{xxx}方式表示路径中的数据
 * 在通过@PathVariable 注解，将占位符的名称和方法中的行参进行绑定
 */



@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所脾气皮的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"}
            ,method = {RequestMethod.GET,RequestMethod.POST})
    public String hello(){
        return "success";
    }
    @RequestMapping("/rest/{username}/{id}")
    public String rest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id"+id);
        System.out.println("username"+username);
        return "success";
    }
}
