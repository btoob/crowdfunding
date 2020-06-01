package com.ryz.crowdfunding.manager.service.impl;

import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.exception.LoginFailException;
import com.ryz.crowdfunding.manager.dao.UserMapper;
import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
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

    @Override
    public Page queryPage(Integer pageno, Integer pagesize) {

        Page page = new Page(pageno, pagesize);

        Integer startIndex = page.getStartIndex();
        List<User> datas = userMapper.queryList(startIndex, pagesize);
        Integer totalSize = userMapper.queryCount();
        page.setDatas(datas);
        page.setTotalSize(totalSize);

        return page;
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}
