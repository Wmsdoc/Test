package com.etc.test.dao.impl;

import com.etc.test.dao.UserDao;


import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class UserDaoImpl implements UserDao {
    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean login(String userName, String password) {
        String sql="select user_name as userName,password from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> user : list) {
            String name = (String) user.get("userName");
            String pass = (String) user.get("password");
            System.out.println(name);
            System.out.println(pass);
            if (userName.equals(name)&&password.equals(pass))
                return true;
        }
        return false;
    }
}

