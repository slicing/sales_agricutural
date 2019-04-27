package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.mapper.PermissionMapper;
import com.example.demo.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 14:15
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> permissions = permissionMapper.selectAll();
        PageInfo pageInfo = new PageInfo(permissions);
        return pageInfo;
    }

    @Override
    public Permission getOne(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectByName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> permissions = permissionMapper.selectByName(name);
        PageInfo pageInfo = new PageInfo(permissions);
        return pageInfo;
    }

    @Override
    public int delete(Permission permission) {
        return permissionMapper.delete(permission);
    }

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }
}
