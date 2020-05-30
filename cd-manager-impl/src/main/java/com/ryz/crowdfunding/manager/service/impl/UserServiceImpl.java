package com.ryz.crowdfunding.manager.service.impl;

import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.exception.LoginFailException;
import com.ryz.crowdfunding.manager.dao.UserMapper;
import com.ryz.crowdfunding.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserlogin(Map<String, Object> paramMap) {

        User user = userMapper.queryUserlogin(paramMap);
        if(user==null){
            throw new LoginFailException("用户名或密码不正确");
        }

        return user;
    }
}
