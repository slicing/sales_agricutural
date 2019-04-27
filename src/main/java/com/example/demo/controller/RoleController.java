package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 17:18
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = roleService.getAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    @GetMapping("/all")
    public Result selectAll(){
        List<Role> roles = roleService.selectAll();
        return new Result("success","查询成功",roles);
    }

    @GetMapping("/Id")
    public Result getOne(Integer id){
        Role role = roleService.getOne(id);
        return new Result("success","查询成功",role);
    }

    @PostMapping("/insert")
    public Result insert(Role role){
        int result = roleService.insert(role);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    @PutMapping("/update")
    public Result update(Role role){
        int result  = roleService.update(role);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
}
