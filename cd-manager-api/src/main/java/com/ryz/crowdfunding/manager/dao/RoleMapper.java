package com.ryz.crowdfunding.manager.dao;

import com.ryz.crowdfunding.bean.Role;
import com.ryz.crowdfunding.bean.RolePermission;
import com.ryz.crowdfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<User> pageQuery(Map paramMap);

    Integer queryCount(Map paramMap);

    void deleteRolePermissionRelationship(Integer roleid);

    int insertRolePermission(RolePermission rp);
}