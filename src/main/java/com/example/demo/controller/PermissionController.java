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

    /**
     * 显示所有信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = permissionService.getAll(pageNum,pageSize);
        return new Result("success", "查询成功",pageInfo );
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/Id")
    public Result getOne(Integer id){
        Permission permission = permissionService.getOne(id);
        return new Result("success", "查询成功",permission);
    }

    /**
     * 根据名称查询
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/Name")
    public Result getName(int pageNum, int pageSize,String name){
        PageInfo pageInfo = permissionService.selectByName(pageNum,pageSize,name);
        return new Result("success", "查询成功",pageInfo );
    }

    /**
     * 增加信息
     * @param permission
     * @return
     */
    @PostMapping("/insert")
    public Result insert(Permission permission){
        int result = permissionService.insert(permission);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    /**
     * 更新信息
     * @param permission
     * @return
     */
    @PutMapping("/update")
    public Result update(Permission permission){
        int result  = permissionService.update(permission);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }


    /**
     * 删除信息
     * @param permission
     * @return
     */
    @PutMapping("/delete")
    public Result delete(Permission permission){
        int result = permissionService.delete(permission);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }
}
