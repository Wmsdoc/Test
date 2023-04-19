package com.etc.test.service.impl;

import com.etc.test.entity.User;
import com.etc.test.mapper.UserMapper;
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
    public Boolean login(String userName, String password) {
        User user = userMapper.login(userName, password);
        return user != null;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(int userId) {
        return userMapper.delete(userId);
    }


}
