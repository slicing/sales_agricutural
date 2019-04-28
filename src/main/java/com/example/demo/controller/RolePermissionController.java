package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 19:19
 */
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 显示所有信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/all")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = rolePermissionService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getOne(Integer id){
        RolePermission rolePermission = rolePermissionService.getOne(id);
        return new Result("success","查询成功",rolePermission);
    }

    /**
     * 根据角色编号查询
     * @param pageNum
     * @param pageSize
     * @param roleId
     * @return
     */
    @GetMapping("/roleId")
    public Result getRoleId(int pageNum, int pageSize, int roleId){
        PageInfo pageInfo = rolePermissionService.selectByRoleId(pageNum,pageSize, roleId);
        return new Result("success","查询成功",pageInfo);
    }


    /**
     * 根据权限编号查询
     * @param pageNum
     * @param pageSize
     * @param permissionId
     * @return
     */
    @GetMapping("/permissionId")
    public Result getPermissionId(int pageNum, int pageSize, int permissionId){
        PageInfo pageInfo = rolePermissionService.selectByPermissionId(pageNum,pageSize, permissionId);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 增加信息
     * @param rolePermission
     * @return
     */
    @PostMapping("/insert")
    public Result insert(RolePermission rolePermission){
        int result = rolePermissionService.insert(rolePermission);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    /**
     * 修改信息
     * @param rolePermission
     * @return
     */
    @PutMapping("/update")
    public Result update(RolePermission rolePermission){
        int result  = rolePermissionService.update(rolePermission);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
}
