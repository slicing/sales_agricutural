package com.example.demo.mapper;

import com.example.demo.entity.Commodity;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommodityMapper extends BaseMapper<Commodity> {

    @Select("select * from commodity where classify_id = #{classifyId")
    List<Commodity> selectByClassifyId(Integer classifyId);

    @Select("select * from commodity where name like concat('%', #{name}, '%')")
    List<Commodity> selectByName(String name);

    @Select("select * from commodity where state = #{state")
    List<Commodity> selectByState(boolean state);

    @Select("select * from commodity where number = #{num")
    List<Commodity> selectByNum(int num);

}