package com.example.demo.mapper;

import com.example.demo.entity.OrderMaster;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import java.util.Date;
import java.util.List;

public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    @Select("select * from order_master where user_id = #{userId}")
    List<OrderMaster> selectByUserId(int userId);

    @Select("select * from order_master where order_state = #{orderState}")
    List<OrderMaster> selectByOrderState(int orderState);

    @Select("select * from order_master where pay_state = #{payState}")
    List<OrderMaster> selectByPayState(boolean payState);

    @Select("select * from order_master where create_time = #{date}")
    List<OrderMaster> selectByCreateTime(Date date);

}