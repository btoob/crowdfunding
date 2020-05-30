package com.ryz.crowdfunding.manager.controller;

import com.ryz.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("这是一个TestController");
//        logger.debug("sfgasg");
        testService.insert();
        return "success";
    }

}
