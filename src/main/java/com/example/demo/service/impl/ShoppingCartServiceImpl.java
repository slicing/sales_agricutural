package com.example.demo.service.impl;

import com.example.demo.entity.ShoppingCart;
import com.example.demo.mapper.ShoppingCartMapper;
import com.example.demo.service.ShoppingCartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 14:41
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectAll();
        PageInfo pageInfo = new PageInfo(shoppingCarts);
        return pageInfo;
    }

    @Override
    public PageInfo selectByUserId(int pageNum, int pageSize, int userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shoppingCarts);
        return pageInfo;
    }

    @Override
    public PageInfo selectByCommodityId(int pageNum, int pageSize, int commodityId) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByCommodityId(commodityId);
        PageInfo pageInfo = new PageInfo(shoppingCarts);
        return pageInfo;
    }

    @Override
    public ShoppingCart getOne(Integer id) {
        return shoppingCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public int update(ShoppingCart shoppingCart) {
        return shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }

    @Override
    public int delete(ShoppingCart shoppingCart) {
        return shoppingCartMapper.delete(shoppingCart);
    }
}
