package com.example.service.impl;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String id) {
        User user=new User();
        user.setName("测试");
        user.setAge(12);
        return user;
    }
}
