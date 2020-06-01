package com.ryz.crowdfunding.controller;

import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.AjaxResult;
import com.ryz.crowdfunding.util.Const;
import com.ryz.crowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){

        //销毁session对象//或者清理session域
        session.invalidate();
        return "redirect:/index.htm";

    }

    //登录功能的同步请求
    /**
    @RequestMapping("/doLogin")
    public String doLogin(String loginacct, String userpswd, String type, HttpSession session){

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("loginacct",loginacct);
        paramMap.put("userpswd",userpswd);
        paramMap.put("type", type);

        User user =  userService.queryUserlogin(paramMap);
        session.setAttribute(Const.LOGIN_USER, user);
        return "redirect:/main.htm";
    }
    **/

    //登录功能的异步请求
    @ResponseBody  //结合Jackson组件，将返回结果转化为字符串，将json串以流的形式返回给客户端
    @RequestMapping("/doLogin")
    public Object doLogin(String loginacct, String userpswd, String type, HttpSession session){

        AjaxResult result = new AjaxResult();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("loginacct",loginacct);
            paramMap.put("userpswd", MD5Util.digest(userpswd));
            paramMap.put("type", type);

            User user =  userService.queryUserlogin(paramMap);
            session.setAttribute(Const.LOGIN_USER, user);
            result.setSuccess(true);
            //{"success":true}
        } catch (Exception e) {
            result.setMessage("账号或密码错误！登录失败");
            e.printStackTrace();
            result.setSuccess(false);
            //{"success":false, "message":"登录失败"}
        }


        return result;
    }
}
