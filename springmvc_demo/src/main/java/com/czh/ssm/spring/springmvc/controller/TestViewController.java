package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public ModelAndView testThymeleafView(ModelAndView modelAndView){
        modelAndView.setViewName("success");
        return modelAndView;
    }





}
