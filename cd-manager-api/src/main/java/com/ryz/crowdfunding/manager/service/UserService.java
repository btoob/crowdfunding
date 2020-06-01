package com.ryz.crowdfunding.manager.service;

import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.util.Page;

import java.util.Map;

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);

    Page queryPage(Integer pageno, Integer pagesize);

    int saveUser(User user);
}
