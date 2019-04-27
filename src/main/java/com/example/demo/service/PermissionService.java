package com.example.demo.service;

import com.example.demo.entity.Permission;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/27 14:07
 */
public interface PermissionService {
    PageInfo getAll(int pageNum, int pageSize);

    Permission getOne(Integer id);

    PageInfo selectByName(int pageNum, int pageSize, String name);

    int delete(Permission permission);

    int insert(Permission permission);

    int update(Permission permission);
}
