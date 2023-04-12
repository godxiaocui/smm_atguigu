package com.czh.spring.controller;

import com.czh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller("controller")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void saveUser(){
        userService.saveUser();
    }
}
