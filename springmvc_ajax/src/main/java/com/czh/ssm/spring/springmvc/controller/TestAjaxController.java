package com.czh.ssm.spring.springmvc.controller;

import com.czh.ssm.spring.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @RequestBody
 *  1.在行参上加上@RequestBody 加上这个注解，可以讲请求提中的参数和行参进行绑定
 *  2.使用RequestBody 注解将json格式的数组转为java对象，三个条件
 *  2.1倒入jackson依赖
 *  2.2在SpringMvc 设置    <mvc:annotation-driven></mvc:annotation-driven>
 *  2.3在处理请求的行参位置，设置要转换的java类型的行参
 *  3.ResponseBody 将控制方法的返回值，作为响应报报文的响应提返回给浏览器
 *  4.ResponseBody 注解响应浏览器json格式的数据
 *  4.1倒入jackson依赖
 *  4.2在SpringMvc 设置    <mvc:annotation-driven></mvc:annotation-driven>
 *  4.3将需要转为json字符串的java对象直接作为控制方法返回，使用@ResponseBody标识控制器的方法
 *  就可以讲java对象直接转换为json字符串响应到浏览器
 *
 *  常用的java对象转换为json结果
 *  实体类转为json对象
 *  map-json对象
 *  list-json数组
 *
 * @RestController 等于 Controller和ResponseBody组合
 */

@Controller
public class TestAjaxController {

    @PostMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response, @RequestBody String requestbody) throws IOException {
        System.out.println(id);
        System.out.println(requestbody);
        response.getWriter().write("hello ajax");

    }
    @PostMapping("/test/RequestBody/json")
    public void testRequestBodyJson(HttpServletResponse response, @RequestBody User user) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello RequestBody");
    }

    @RequestMapping("/test/RequestBody")
    @ResponseBody
    public String testRequestBody(){
        return "success";
    }

    @PostMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBody(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setAge(18);
        user.setGender("男");
        return user;
    }
}
