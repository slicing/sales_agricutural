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

    /**
     * 查找所有的用户角色关系
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = userRoleService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 根据用户编号查询
     * @param userId
     * @return
     */
    @GetMapping("/UserId")
    public Result getUserId( int userId){
        UserRole userRole = userRoleService.selectByUserId(userId);
        return new Result("success","查询成功",userRole);
    }

    /**
     * 根据角色编号查询
     * @param pageNum
     * @param pageSize
     * @param roleId
     * @return
     */
    @GetMapping("/RoleId")
    public Result getRoleId(int pageNum, int pageSize, int roleId){
        PageInfo pageInfo = userRoleService.selectByRoleId(pageNum,pageSize, roleId);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/Id")
    public Result getOne( Integer id){
        UserRole userRole = userRoleService.getOne(id);
        return new Result("success","查询成功",userRole);
    }

    /**
     * 增加关系
     * @param userRole
     * @return
     */
    @PostMapping("/insert")
    public Result insert(UserRole userRole){
        int result = userRoleService.insert(userRole);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }


    /**
     * 修改关系
     * @param userRole
     * @return
     */
    @PutMapping("/update")
    public Result update(UserRole userRole){
        int result = userRoleService.update(userRole);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
}
