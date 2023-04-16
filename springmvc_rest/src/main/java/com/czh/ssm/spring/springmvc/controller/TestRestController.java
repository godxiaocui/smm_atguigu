package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 查询所有用户的信息 --> /user-->get
 * 根据id查询用户的信息 --> /user/1-->get
 * 修改用户的信息 --> /user-->put
 * 添加查询用户的信息 --> /user-->post
 * 删除用户的信息 --> /user/1 --> delete
 *
 *目前浏览器支持post和get 如果要发put和delete请求，需要在web.xml中增加一个HiddenHttpMethodFilter
 *  配置了过滤器，还要配两个条件
 *  1. 请求必须要为post
 *  2. 必须要这么弄<input type="hidden" name="_method" value="put">
 *
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户的信息 --> /user-->get");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户的信息 --> /user/1-->get");
        System.out.println("id"+id);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加查询用户的信息 --> /user-->post");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户的信息 --> /user-->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户的信息 --> /user/1 --> delete");
        System.out.println(id);
        return "success";
    }
}
