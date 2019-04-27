package com.example.demo.service;

import com.example.demo.entity.OrderMaster;
import com.github.pagehelper.PageInfo;

import java.util.Date;

/**
 * @Author: slicing
 * @Date: 2019/4/27 14:57
 */
public interface OrderMasterService {
    PageInfo selectAll(int pageNum, int pageSize);

    OrderMaster getOne(Integer id);

    PageInfo selectByUserId(int pageNum, int pageSize,Integer userId);

    PageInfo selectByOrderState(int pageNum, int pageSize, int orderState);

    PageInfo selectByPayState(int pageNum, int pageSize, boolean payState);

    PageInfo selectByCreateTime(int pageNum, int pageSize, Date date);

    int insert(OrderMaster orderMaster);

    int update(OrderMaster orderMaster);

    int delete(OrderMaster orderMaster);



}
