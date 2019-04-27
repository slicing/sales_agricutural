package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;


public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name like concat('%', #{name}, '%')")
    User selectByName(String name);
}