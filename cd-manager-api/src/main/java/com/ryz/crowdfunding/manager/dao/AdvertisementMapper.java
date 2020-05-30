package com.ryz.crowdfunding.manager.dao;

import com.ryz.crowdfunding.bean.Advertisement;
import com.ryz.crowdfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface AdvertisementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advertisement record);

    Advertisement selectByPrimaryKey(Integer id);

    List<Advertisement> selectAll();

    int updateByPrimaryKey(Advertisement record);

    List<User> pageQuery(Map paramMap);

    Integer queryCount(Map paramMap);
}