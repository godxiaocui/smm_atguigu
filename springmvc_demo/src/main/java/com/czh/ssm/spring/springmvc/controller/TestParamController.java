package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取请求方式1（不常用）
 * 因为底层是dispatchservlet的方式所以是会用HttpServletRequest的参数
 * 本质还是通过HttpServletRequest 去获取参数的形式获取请求参数
 * @RequestParam
 * 获取请求方式2直接写参数的名字
 * 参数名称和传参数的名称相同就行了
 * 如果不一致可以用。@RequestParam注解value就是行参的名字，required默认是true就是必须要传参数
 * @ReaquestHeader 将请求头信息和控制器方法的行参绑定
 * @CookieValue    将cookie信息和控制器方法的行参绑定
 *
 *
 *
 *
 *
 */
@Controller
public class TestParamController {

@RequestMapping("/param/servlet")
    public  String getParameter(HttpServletRequest request){
    HttpSession session = request.getSession();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println("***********");
    System.out.println(username+password);
    return "success";

}
    @RequestMapping("/param/servletAPI")
    public  String getParameterServletAPI(
            @RequestParam(value = "username",required = false) String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jssionid
            ){
        System.out.println(username+password);
        System.out.println(referer);
        System.out.println(jssionid);
        return "success";
    }


}
