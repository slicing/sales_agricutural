package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/27 9:11
 */
public interface RolePermissionService {
    PageInfo selectAll(int pageNum, int pageSize);

    PageInfo selectByRoleId(int pageNum, int pageSize, Integer roleId);

    PageInfo selectByPermissionId(int pageNum, int pageSize, Integer permissionId);

    RolePermission getOne(Integer id);

    int insert(RolePermission rolePermission);

    int update(RolePermission rolePermission);
}
