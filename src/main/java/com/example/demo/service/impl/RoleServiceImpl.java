package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/26 22:34
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageInfo getAll(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roles = roleMapper.selectAll();
        PageInfo pageInfo = new PageInfo(roles);
        return pageInfo;
    }

    @Override
    public Role getOne(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }
}
