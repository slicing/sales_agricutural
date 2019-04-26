package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/26 22:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;

    }
    @Override
    public User getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
