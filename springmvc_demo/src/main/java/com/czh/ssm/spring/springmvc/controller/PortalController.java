package com.czh.ssm.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {
    @RequestMapping("/")
    public String portal(){

        return "index";
}

}
