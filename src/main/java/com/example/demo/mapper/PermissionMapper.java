package com.example.demo.mapper;

import com.example.demo.entity.Permission;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("select * from permission where name like concat('%', #{name}, '%')")
    List<Permission> selectByName(String name);

}