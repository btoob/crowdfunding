package com.ryz.crowdfunding.manager.service;

import com.ryz.crowdfunding.bean.Role;
import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.util.Page;
import com.ryz.crowdfunding.vo.Data;

import java.util.List;
import java.util.Map;

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);

//    Page queryPage(Integer pageNo, Integer pagesize);

    int saveUser(User user);

    Page queryPage(Map<String, Object> paramMap);

    User queryById(Integer id);

    int updateUser(User user);

    int deleteUser(Integer id);

    int deleteBatchUser(Integer[] id);

    int deleteBatchUserByVO(Data data);

    List<Role> queryAllRole();

    List<Integer> queryRoleByUserId(Integer id);

    int deleteUserRoleRelationship(Integer userid, Data data);

    int saveUserRoleRelationship(Integer userid, Data data);
}
