package com.czh.ssm.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

     @RequestMapping("/test/hello")
    public String hello(){
         System.out.println(1/0);
        return "success";
    }

}
