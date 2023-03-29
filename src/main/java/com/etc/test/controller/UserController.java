package com.etc.test.controller;

import com.etc.test.entity.JsonResult;
import com.etc.test.entity.User;
import com.etc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public JsonResult<User> queryAll(){
        return new JsonResult<User>(userService.queryAll());
    }
}
