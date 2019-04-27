package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.UserRole;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.UserRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 18:35
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = userRoleService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    @GetMapping("/UserId")
    public Result getUserId( int userId){
        UserRole userRole = userRoleService.selectByUserId(userId);
        return new Result("success","查询成功",userRole);
    }

    @GetMapping("/RoleId")
    public Result getRoleId(int pageNum, int pageSize, int roleId){
        PageInfo pageInfo = userRoleService.selectByRoleId(pageNum,pageSize, roleId);
        return new Result("success","查询成功",pageInfo);
    }

    @GetMapping("/Id")
    public Result getOne( Integer id){
        UserRole userRole = userRoleService.getOne(id);
        return new Result("success","查询成功",userRole);
    }

    @PostMapping("/insert")
    public Result insert(UserRole userRole){
        int result = userRoleService.insert(userRole);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }


    @PutMapping("/update")
    public Result update(UserRole userRole){
        int result = userRoleService.update(userRole);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
}
