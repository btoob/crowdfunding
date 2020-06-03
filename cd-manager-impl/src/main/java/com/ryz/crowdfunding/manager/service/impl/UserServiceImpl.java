package com.ryz.crowdfunding.manager.service.impl;

import com.ryz.crowdfunding.bean.Role;
import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.exception.LoginFailException;
import com.ryz.crowdfunding.manager.dao.UserMapper;
import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.Const;
import com.ryz.crowdfunding.util.MD5Util;
import com.ryz.crowdfunding.util.Page;
import com.ryz.crowdfunding.vo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
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
     **/

    @Override
    public int saveUser(User user) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createTime = sdf.format(date);

        user.setCreatetime(createTime);
        user.setUserpswd(MD5Util.digest(Const.PASSWORD));
        return userMapper.insert(user);
    }

    @Override
    public Page queryPage(Map<String, Object> paramMap) {
        Page page = new Page((Integer) paramMap.get("pageNo"), (Integer) paramMap.get("pageSize"));

        Integer startIndex = page.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<User> datas = userMapper.queryList(paramMap);
        Integer totalSize = userMapper.queryCount(paramMap);
        page.setDatas(datas);
        page.setTotalSize(totalSize);

        return page;
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchUser(Integer[] ids) {
        int totalCount = 0 ;
        for (Integer id : ids) {
            int count = userMapper.deleteByPrimaryKey(id);
            totalCount += count;
        }
        if(totalCount!=ids.length){
            throw new RuntimeException("批量删除失败");
        }
        return totalCount;
    }

    @Override
    public int deleteBatchUserByVO(Data data) {
        return userMapper.deleteBatchUserByVo(data);
    }

    @Override
    public List<Role> queryAllRole() {
        return userMapper.queryAllRole();
    }

    @Override
    public List<Integer> queryRoleByUserId(Integer id) {
        return userMapper.queryRoleByUserId(id);
    }

    @Override
    public int deleteUserRoleRelationship(Integer userid, Data data) {
        return userMapper.deleteUserRoleRelationship(userid, data);
    }

    @Override
    public int saveUserRoleRelationship(Integer userid, Data data) {
        return userMapper.saveUserRoleRelationship(userid, data);
    }
}
