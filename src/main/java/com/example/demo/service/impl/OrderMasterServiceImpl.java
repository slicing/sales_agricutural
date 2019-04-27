package com.example.demo.service.impl;

import com.example.demo.entity.OrderMaster;
import com.example.demo.mapper.OrderMasterMapper;
import com.example.demo.service.OrderMasterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 15:20
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasterList = orderMasterMapper.selectAll();
        PageInfo pageInfo = new PageInfo(orderMasterList);
        return pageInfo;
    }

    @Override
    public OrderMaster getOne(Integer id) {
        return orderMasterMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectByUserId(int pageNum, int pageSize, Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasterList = orderMasterMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(orderMasterList);
        return pageInfo;
    }

    @Override
    public PageInfo selectByOrderState(int pageNum, int pageSize, int orderState) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasterList = orderMasterMapper.selectByOrderState(orderState);
        PageInfo pageInfo = new PageInfo(orderMasterList);
        return pageInfo;
    }

    @Override
    public PageInfo selectByPayState(int pageNum, int pageSize, boolean payState) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasterList = orderMasterMapper.selectByPayState(payState);
        PageInfo pageInfo = new PageInfo(orderMasterList);
        return pageInfo;
    }

    @Override
    public PageInfo selectByCreateTime(int pageNum, int pageSize, Date date) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasterList = orderMasterMapper.selectByCreateTime(date);
        PageInfo pageInfo = new PageInfo(orderMasterList);
        return pageInfo;
    }

    @Override
    public int insert(OrderMaster orderMaster) {
        return orderMasterMapper.insert(orderMaster);
    }

    @Override
    public int update(OrderMaster orderMaster) {
        return orderMasterMapper.updateByPrimaryKeySelective(orderMaster);
    }

    @Override
    public int delete(OrderMaster orderMaster) {
        return orderMasterMapper.delete(orderMaster);
    }
}
