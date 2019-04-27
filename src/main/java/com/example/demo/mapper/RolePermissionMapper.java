package com.example.demo.mapper;

import com.example.demo.entity.RolePermission;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePermissionMapper  extends BaseMapper<RolePermission> {

    @Select("select * from role_permission where role_id = #{roleId}")
    List<RolePermission> selectByRoleId(Integer roleId);

    @Select("select * from role_permission where permission_id = #{permissionId}")
    List<RolePermission> selectByPermissionId(Integer permissionId);

}