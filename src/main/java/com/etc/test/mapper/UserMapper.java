package com.etc.test.mapper;

import com.etc.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    List<User> queryAll();

    /**
     * 登录
     *
     * @return User
     */
    User login(String userName,String password);

    /**
     * 增加用户
     *
     * @return int
     */
    int insert(User user);

    /**
     * 修改用户
     *
     * @return int
     */
    int update(User user);

    /**
     * 删除用户
     *
     * @return int
     */
    int delete(int userId);
}
