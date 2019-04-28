package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 16:49
 */
@RestController
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/all")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = userService.getAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 根据编号查询某一用户
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getOne(Integer id){
        User user = userService.getOne(id);
        return new Result("success","查询成功",user);
    }

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getName(String name){
        User user = userService.getByName(name);
        return new Result("success","查询成功",user);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public Result insert(User user){
        int result = userService.insert(user);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    /**
     * 更新数据（修改密码）
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(User user){
        int result = userService.update(user);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

}
