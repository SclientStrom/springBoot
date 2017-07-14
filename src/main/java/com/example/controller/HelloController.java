package com.example.controller;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/7/4.
 */
@Controller
@EnableAutoConfiguration
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/index")
    @ResponseBody
    public User index(){
        User user=new User();
        user.setName("rest");
        user.setAge(12);
        return user;
    }
    @RequestMapping("/user/1")
    public ModelAndView welcome() {
        //逻辑处理
        ModelAndView model=new ModelAndView("user/welcome");
        model.addObject("u","use");
        return model;
    }
    @GetMapping("/templates")
    String test1() {
        //逻辑处理
        return "index";
    }
    @GetMapping("/templates/user")
    String user() {
        //逻辑处理
        return "user/user";
    }
    @RequestMapping("/{id}")
    @ResponseBody
    public User  getUserById(@PathVariable(value = "id")Integer id){
        System.out.print("id:" +id);
        return userMapper.getUserById(id);
    }
}
