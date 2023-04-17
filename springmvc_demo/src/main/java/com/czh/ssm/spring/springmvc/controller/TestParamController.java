package com.czh.ssm.spring.springmvc.controller;

import com.czh.ssm.spring.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取请求方式1（不常用）
 * 因为底层是dispatchservlet的方式所以是会用HttpServletRequest的参数
 * 本质还是通过HttpServletRequest 去获取参数的形式获取请求参数
 * 3.@RequestParam（重要）
 * 获取请求方式2直接写参数的名字
 * 参数名称和传参数的名称相同就行了
 * 如果不一致可以用。@RequestParam注解value就是行参的名字，required默认是true就是必须要传参数
 * 4.@ReaquestHeader 将请求头信息和控制器方法的行参绑定
 * 5. @CookieValue    将cookie信息和控制器方法的行参绑定
 * 6.通过一实体类类型的行参获取请求参数（常用）
 * 需要在控制器方法的行参位置设置实体类行参
 * 要保证实体类中的属性属性名和请求的参数的名字一致（属性指的是get和set方法，而不是成员变量）
 * 通过实体类获取数据
 *7. 解决请求参数中参数乱码的问题
 * 在web.xml 配置编码过滤器
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
    @RequestMapping("/param/pojo")
    public String ParamPojo(User user){
        System.out.println(user);
        return "success";
    }




}
