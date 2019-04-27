package com.example.demo.mapper;

import com.example.demo.entity.OrderDetail;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> selectByOrderId(int orderId);

    @Select("select * from order_detail where commodity_id = #{commodityId}")
    List<OrderDetail> selectByCommodityId(int commodityId);

    @Select("select * from order_detail where commodity_name like concat('%', #{commodityName}, '%')")
    List<OrderDetail> selectByCommodityName(String commodityName);

}