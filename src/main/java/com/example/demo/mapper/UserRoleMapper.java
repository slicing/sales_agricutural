package com.example.demo.mapper;


import com.example.demo.entity.UserRole;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper  extends BaseMapper<UserRole> {

    @Select("select * from user_role where role_id = #{role_id}")
    List<UserRole> selectByRoleId(Integer role_id);

    @Select("select * from user_role where user_id = #{user_id}")
    UserRole selectByUserId(Integer user_id);


}