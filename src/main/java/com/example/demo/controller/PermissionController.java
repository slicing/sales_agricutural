package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Result;
import com.example.demo.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 18:50
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = permissionService.getAll(pageNum,pageSize);
        return new Result("success", "查询成功",pageInfo );
    }

    @GetMapping("/Id")
    public Result getOne(Integer id){
        Permission permission = permissionService.getOne(id);
        return new Result("success", "查询成功",permission);
    }

    @GetMapping("/Name")
    public Result getAll(int pageNum, int pageSize,String name){
        PageInfo pageInfo = permissionService.selectByName(pageNum,pageSize,name);
        return new Result("success", "查询成功",pageInfo );
    }

    @PostMapping("/insert")
    public Result insert(Permission permission){
        int result = permissionService.insert(permission);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    @PutMapping("/update")
    public Result update(Permission permission){
        int result  = permissionService.update(permission);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }


    @PutMapping("/delete")
    public Result delete(Permission permission){
        int result = permissionService.delete(permission);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }
}
