package com.example.demo.service;

import com.example.demo.entity.OrderDetail;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/27 16:20
 */
public interface OrderDetailService {
    PageInfo selectAll(int pageNum, int pageSize);

    PageInfo selectByOrderId(int pageNum, int pageSize, int orderId);

    OrderDetail getOne(Integer id);

    PageInfo selectByCommodityId(int pageNum, int pageSize, int commodityId);

    PageInfo selectCommodityName(int pageNum, int pageSize, String commodityName);

    int insert(OrderDetail orderDetail);

    int update(OrderDetail orderDetail);

    int delete(OrderDetail orderDetail);

}
