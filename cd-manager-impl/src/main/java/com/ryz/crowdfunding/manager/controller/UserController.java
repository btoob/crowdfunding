package com.ryz.crowdfunding.manager.controller;

import com.ryz.crowdfunding.bean.Role;
import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.AjaxResult;
import com.ryz.crowdfunding.util.Page;
import com.ryz.crowdfunding.util.StringUtil;
import com.ryz.crowdfunding.vo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/toList")
    public String toList(){
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }

    //分配角色
    @ResponseBody
    @RequestMapping("/doAssignRole")
    public Object doAssignRole(Integer userid, Data data){
        AjaxResult result = new AjaxResult();
        try {

            userService.saveUserRoleRelationship(userid, data);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("分配失败!");
        }

        return result;
    }

    //取消角色
    @ResponseBody
    @RequestMapping("/doUnAssignRole")
    public Object doUnAssignRole(Integer userid, Data data){
        AjaxResult result = new AjaxResult();
        try {

            userService.deleteUserRoleRelationship(userid, data);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("取消角色失败!");
        }

        return result;
    }

    //显示分配页面的数据
    @RequestMapping("/assignRole")
    public String assignRole(Integer id, Map map){

        List<Role> allRoleList = userService.queryAllRole();
        List<Integer> roleIds = userService.queryRoleByUserId(id);

        List<Role> leftRoleList = new ArrayList<>();
        List<Role> rightRoleList = new ArrayList<>();

        for (Role role : allRoleList) {
            if(roleIds.contains(role.getId())){
                rightRoleList.add(role);
            }else {
                leftRoleList.add(role);
            }
        }

        map.put("leftRoleList", leftRoleList);
        map.put("rightRoleList", rightRoleList);

        return "user/assignRole";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Map map){
        User user = userService.queryById(id);
        map.put("user", user);

        return "user/update";
    }

    //接收多条数据.
    @ResponseBody
    @RequestMapping("/doDeleteBatch")
    public Object doDeleteBatch(Data data){
        AjaxResult result = new AjaxResult();
        try {

            int count = userService.deleteBatchUserByVO(data);
            result.setSuccess(count==data.getDatas().size());
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("删除数据失败!");
        }

        return result;
    }


    //异步请求----批量删除管理员用户---//接收一个参数名带多个值.
    /**
    @ResponseBody
    @RequestMapping("/doDeleteBatch")
    public Object doDeleteBatch(Integer[] id){
        AjaxResult result = new AjaxResult();
        try {

            int count = userService.deleteBatchUser(id);
            result.setSuccess(count==id.length);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("删除数据失败!");
        }

        return result;
    }
    **/

    //异步请求----修改管理员用户
    @ResponseBody
    @RequestMapping("/doUpdate")
    public Object doUpdate(User user){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.updateUser(user);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("修改管理员用户失败！");
        }
        return result;
    }

    //异步请求----删除管理员用户
    @ResponseBody
    @RequestMapping("/doDelete")
    public Object doDelete(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.deleteUser(id);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("删除管理员用户失败！");
        }
        return result;
    }

    //异步请求----添加管理员用户
    @ResponseBody
    @RequestMapping("/doAdd")
    public Object doAdd(User user){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.saveUser(user);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("新增管理员用户失败！");
        }
        return result;
    }


    //异步请求----条件查询
    @ResponseBody
    @RequestMapping("/list")
    public Object list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                       String queryText){
        AjaxResult result = new AjaxResult();
        try {
            Map paramMap = new HashMap();
            paramMap.put("pageNo", pageNo);
            paramMap.put("pageSize", pageSize);

            if(StringUtil.isNotEmpty(queryText)){
                paramMap.put("queryText", queryText);
            }
            Page page = userService.queryPage(paramMap);

            result.setSuccess(true);
            result.setPage(page);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("查询数据失败！");
        }
        return result;
    }

    /**
    //异步请求
    @ResponseBody
    @RequestMapping("/list")
    public Object list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){

        AjaxResult result = new AjaxResult();
        try {
            Page page = userService.queryPage(pageNo, pageSize);
            result.setSuccess(true);
            result.setPage(page);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("查询数据失败！");
        }
        return result;
    }
    **/

    //同步请求
    /**
    @RequestMapping("/list")
    public String list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                        Map map){
        Page page = userService.queryPage(pageNo, pageSize);
        map.put("page", page);
        return "user/list-1";
    }
    **/



}
