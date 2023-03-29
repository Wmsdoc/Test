package com.etc.test.service.impl;

import com.etc.test.mapper.UserMapper;
import com.etc.test.entity.User;
import com.etc.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public String login(String userName, String password) {
        List<User> list = userMapper.queryAll();
        for (User user : list) {
            String name = user.getUserName();
            String pass = user.getPassword();
            System.out.println(name);
            System.out.println(pass);
            if (userName.equals(name)&&password.equals(pass))
                return "登录成功";
        }
        return "用户名或密码错误";
    }
}
