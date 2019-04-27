package com.example.demo.service.impl;

import com.example.demo.entity.OrderDetail;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.service.OrderDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 16:24
 */
@Service
public class OrdrDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail> orderDetails = orderDetailMapper.selectAll();
        PageInfo pageInfo = new PageInfo(orderDetails);
        return pageInfo;
    }

    @Override
    public PageInfo selectByOrderId(int pageNum, int pageSize, int orderId) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(orderId);
        PageInfo pageInfo = new PageInfo(orderDetails);
        return pageInfo;
    }

    @Override
    public OrderDetail getOne(Integer id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectByCommodityId(int pageNum, int pageSize, int commodityId) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByCommodityId(commodityId);
        PageInfo pageInfo = new PageInfo(orderDetails);
        return pageInfo;
    }

    @Override
    public PageInfo selectCommodityName(int pageNum, int pageSize, String commodityName) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByCommodityName(commodityName);
        PageInfo pageInfo = new PageInfo(orderDetails);
        return pageInfo;
    }

    @Override
    public int insert(OrderDetail orderDetail) {
        return orderDetailMapper.insert(orderDetail);
    }

    @Override
    public int update(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public int delete(OrderDetail orderDetail) {
        return orderDetailMapper.delete(orderDetail);
    }
}
