package com.etc.test.mapper;

import com.etc.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryAll();
}
