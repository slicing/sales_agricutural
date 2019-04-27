package com.example.demo.mapper;

import com.example.demo.entity.Classify;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface ClassifyMapper extends BaseMapper<Classify> {

    @Select("select * from classify where name like concat('%', #{name}, '%')")
    Classify selectByName(String name);

}