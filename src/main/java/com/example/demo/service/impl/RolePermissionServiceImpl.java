package com.example.demo.service.impl;

import com.example.demo.entity.RolePermission;
import com.example.demo.mapper.RolePermissionMapper;
import com.example.demo.service.RolePermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 9:18
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RolePermission> rolePermissionList = rolePermissionMapper.selectAll();
        PageInfo pageInfo = new PageInfo(rolePermissionList);
        return  pageInfo;
    }

    @Override
    public PageInfo selectByRoleId(int pageNum, int pageSize, Integer roleId) {
        PageHelper.startPage(pageNum,pageSize);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByRoleId(roleId);
        PageInfo pageInfo = new PageInfo(rolePermissions);
        return pageInfo;

    }

    @Override
    public PageInfo selectByPermissionId(int pageNum, int pageSize, Integer permissionId) {
        PageHelper.startPage(pageNum,pageSize);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByPermissionId(permissionId);
        PageInfo pageInfo = new PageInfo(rolePermissions) ;
        return pageInfo;
    }

    @Override
    public RolePermission getOne(Integer id) {
        return rolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(RolePermission rolePermission) {
        return rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public int update(RolePermission rolePermission) {
        return rolePermissionMapper.updateByPrimaryKeySelective(rolePermission);
    }
}
