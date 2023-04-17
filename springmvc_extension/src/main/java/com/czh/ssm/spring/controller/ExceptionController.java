package com.czh.ssm.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 作用注解定义异常
 * ControllerAdvice 将当前表示为异常处理的组件
 */
@ControllerAdvice
public class ExceptionController {

    // 注解中添加如果出现异常的名称
    @ExceptionHandler(ArithmeticException.class)
    public String  handleException(Model model,Throwable ex){
        // 参数中带有异常
        model.addAttribute("ex",ex);
        return "error";
    }
}
