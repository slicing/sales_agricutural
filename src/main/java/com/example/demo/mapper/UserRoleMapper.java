package com.example.demo.mapper;


import com.example.demo.entity.UserRole;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper  extends BaseMapper<UserRole> {

    @Select("select * from user_role where role_id = #{roleId}")
    List<UserRole> selectByRoleId(Integer roleId);

    @Select("select * from user_role where user_id = #{userId}")
    UserRole selectByUserId(Integer userId);


}