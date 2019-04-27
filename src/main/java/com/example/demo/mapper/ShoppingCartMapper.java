package com.example.demo.mapper;

import com.example.demo.entity.ShoppingCart;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    @Select("select * from shopping_cart where user_id = userId")
    List<ShoppingCart> selectByUserId(Integer userId);

    @Select("select * from shopping_cart where commodity_id = commodityId")
    List<ShoppingCart> selectByCommodityId(Integer commodityId);



}