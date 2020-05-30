package com.ryz.crowdfunding.manager.dao;

import com.ryz.crowdfunding.bean.Param;

import java.util.List;

public interface ParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Param record);

    Param selectByPrimaryKey(Integer id);

    List<Param> selectAll();

    int updateByPrimaryKey(Param record);
}