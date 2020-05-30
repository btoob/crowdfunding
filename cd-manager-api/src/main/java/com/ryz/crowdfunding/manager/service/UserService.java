package com.ryz.crowdfunding.manager.service;

import com.ryz.crowdfunding.bean.User;

import java.util.Map;

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);
}
