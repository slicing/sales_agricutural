package com.example.demo.service.impl;

import com.example.demo.entity.UserRole;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/26 23:00
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserRole> userRoles = userRoleMapper.selectAll();
        PageInfo pageInfo = new PageInfo(userRoles);
        return pageInfo;
    }

    @Override
    public PageInfo selectByRoleId(int pageNum, int pageSize, Integer role_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserRole> userRoles = userRoleMapper.selectByRoleId(role_id);
        PageInfo pageInfo = new PageInfo(userRoles);
        return pageInfo;
    }

    @Override
    public UserRole selectByUserId(Integer user_id) {
        return userRoleMapper.selectByUserId(user_id);
    }

    @Override
    public UserRole getOne(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public int update(UserRole userRole) {
        return userRoleMapper.updateByPrimaryKeySelective(userRole);
    }
}
