package com.example.mapper;


import com.example.mapper.entity.User;

import java.util.List;

/**
 * Created by ThinkPad on 2017/7/14.
 */
public interface UserRoleMapper {

    public  User findByUserName(String username);

}
