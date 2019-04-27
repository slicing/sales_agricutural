package com.example.demo.service;
import com.example.demo.entity.UserRole;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/26 22:48
 */
public interface UserRoleService {

    PageInfo selectAll(int pageNum, int pageSize);

    PageInfo selectByRoleId(int pageNum, int pageSize, Integer roleId);

    UserRole selectByUserId(Integer userId);

    UserRole getOne(Integer id);

    int insert(UserRole userRole);

    int update(UserRole userRole);



}
