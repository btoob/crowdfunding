package com.ryz.crowdfunding.manager.dao;

import com.ryz.crowdfunding.bean.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserlogin(Map<String, Object> paramMap);

    //List<User> queryList(@Param("startIndex") Integer startIndex,
                        // @Param("pageSize") Integer pageSize);

    //Integer queryCount();

    Integer queryCount(Map<String, Object> paramMap);

    List<User> queryList(Map<String, Object> paramMap);
}