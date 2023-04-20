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
     * @return login.html
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }



    /**
     * 登录验证
     * @param userName String类型
     * @param password String类型
     * @return user/list.html || login.html
     */
    @GetMapping("/dologin")
    public String dologin(@RequestParam("userName") String userName,@RequestParam("password") String password){
        Boolean result = userService.login(userName, password);
        if (result)
            return "redirect:/user/list";
        else
            return "login";
    }

}
