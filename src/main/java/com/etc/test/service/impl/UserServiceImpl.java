package com.etc.test.service.impl;

import com.etc.test.dao.UserDao;
import com.etc.test.service.UserService;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public String login(String userName, String password) {
        boolean result=userDao.login(userName, password);
        if (result)
        {
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
