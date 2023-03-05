package com.etc.test.controller;

import com.etc.test.service.UserService;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Resource
    UserService userService;
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String dologin(@RequestParam("userName") String userName,@RequestParam("password") String password){

        return userService.login(userName, password);
    }

}
