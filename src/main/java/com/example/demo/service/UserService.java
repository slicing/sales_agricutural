package com.example.demo.service;
import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;


/**
 * @Author: slicing
 * @Date: 2019/4/26 22:09
 */
public interface UserService {
    PageInfo getAll( int pageNum, int pageSize);

    User getOne(Integer id);

    int insert(User user);

    int update(User user);

}
