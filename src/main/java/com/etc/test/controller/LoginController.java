package com.etc.test.controller;

import com.etc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    UserService userService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }



    @GetMapping("/dologin")
    public String dologin(@RequestParam("userName") String userName,@RequestParam("password") String password){
        Boolean result = userService.login(userName, password);
        if (result)
            return "redirect:/user/list";
        else
            return "login";
    }

}
