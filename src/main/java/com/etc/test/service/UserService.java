package com.etc.test.service;

import com.etc.test.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
    String  login(String userName,String password);
}
