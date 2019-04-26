package com.example.demo.service;

import com.example.demo.entity.Role;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/26 22:33
 */
public interface RoleService {
    PageInfo getAll(int pageSize, int pageNum);

    Role getOne(Integer id);

    int insert(Role role);

    int update(Role role);

}
