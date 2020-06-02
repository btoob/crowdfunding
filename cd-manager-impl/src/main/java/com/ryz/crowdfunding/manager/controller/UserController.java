package com.ryz.crowdfunding.manager.controller;

import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.AjaxResult;
import com.ryz.crowdfunding.util.Page;
import com.ryz.crowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.PAData;

import java.util.HashMap;
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
