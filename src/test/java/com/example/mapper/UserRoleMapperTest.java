package com.example.mapper;

import com.example.mapper.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ThinkPad on 2017/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {
    @Autowired
    private UserRoleMapper roleMapper;

    @Test
    public void findByUserName() throws Exception {
        User user=roleMapper.findByUserName("xyycici");
        System.out.println(user);
    }
}