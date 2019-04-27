package com.example.demo.service;

import com.example.demo.entity.ShoppingCart;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/27 14:31
 */
public interface ShoppingCartService {
    PageInfo selectAll(int pageNum, int pageSize);

    PageInfo selectByUserId(int pageNum, int pageSize, int userId);

    PageInfo selectByCommodityId(int pageNum, int pageSize, int commodityId);

    ShoppingCart getOne(Integer id);

    int insert(ShoppingCart shoppingCart);

    int update(ShoppingCart shoppingCart);

    int delete(ShoppingCart shoppingCart);
}
