package com.etc.test.controller;

import com.etc.test.entity.JsonResult;
import com.etc.test.entity.User;
import com.etc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     *
     * @return user.html
     */
    @GetMapping("/list")
    public String queryAll(Model model){
        List<User> list = userService.queryAll();
        model.addAttribute("userList",list);
        return "user";
    }

    /**
     * 新增用户
     *
     */
    @GetMapping("/add")
    public JsonResult<?> insert(User user){
        int result = userService.insert(user);
        if (result == 0)
            return new JsonResult<>("新增失败");
        else
            return new JsonResult<>("新增成功");
    }
    /**
     * 修改用户
     *
     */
    @GetMapping("/update")
    public JsonResult<?> update(User user){
        int result = userService.update(user);
        if (result == 0)
            return new JsonResult<>("修改失败");
        else
            return new JsonResult<>("修改成功");
    }
    /**
     * 删除用户
     *
     */
    @GetMapping("/delete")
    public JsonResult<?> delete(int userId){
        int result = userService.delete(userId);
        if (result == 0)
            return new JsonResult<>("删除失败");
        else
            return new JsonResult<>("删除成功");
    }
}
