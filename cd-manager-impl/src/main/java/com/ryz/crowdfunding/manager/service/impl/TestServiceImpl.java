package com.ryz.crowdfunding.manager.service.impl;

import com.ryz.crowdfunding.manager.dao.TestDao;
import com.ryz.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;


    public void insert() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "yujin");


        testDao.insert(map);
    }
}
