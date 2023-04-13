package com.etc.test.service;

import com.etc.test.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
    Boolean login(String userName,String password);

    int insert(User user);

    int update(User user);

    int delete(int userId);
}
