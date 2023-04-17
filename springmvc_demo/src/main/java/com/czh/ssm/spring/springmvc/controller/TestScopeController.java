package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 向域中共享数据
 * 1. 通过ModelAndView向请求域中共享数据
 * 使用ModelAndView可以使用Model功能向请求域中共享数据
 * 使用view功能设置逻辑视图，但使用控制器方法一定要讲ModelandView作为方法的返回值
 * 2. 使用model功能
 * model
 * modelmap
 * map 都是可以的
 * model 和modelmap和map 的关系
 * 在底层中，这些类型的行参都是通过bindingAwareModelMap创建的
 */
@Controller
public class TestScopeController {
    @RequestMapping("/modelandview/mav")
    public ModelAndView TestModelAndView(){
        /**
         * ModelAndView 包含Model 和 View
         * Model：向请求域中共享数据
         * View：设置逻辑试图的跳转
         */
        ModelAndView modelAndView = new ModelAndView();
        //Model：向请求域中共享数据
        modelAndView.addObject("testRequestScope","hello,ModelAndView");
        // 设置逻辑视图
        modelAndView.setViewName("success");
        return modelAndView;

    }

    @RequestMapping("/modelandview/model")
    public String Model(Model model){
        model.addAttribute("testRequestScope","hello,ModelAndView");
        return "success";
    }

    @RequestMapping("/modelandview/modelMap")
    public String ModelMap(ModelMap modelMap){
       modelMap.addAttribute("testRequestScope","hello,ModelAndView");
        return "success";
    }
    @RequestMapping("/modelandview/Map")
    public String TestMap(Map<String,Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String TestSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";

    }

    @RequestMapping("/test/application")
    public String Testapplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,applicatiopn");
        return "success";

    }


}
