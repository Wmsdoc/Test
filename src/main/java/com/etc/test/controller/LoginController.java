package com.etc.test.controller;

import com.etc.test.service.UserService;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String dologin(@RequestParam("userName") String userName,@RequestParam("password") String password){

        return userService.login(userName, password);
    }

}
