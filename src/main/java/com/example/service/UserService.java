package com.example.service;

import com.example.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@WebService
public interface UserService {

    @WebMethod
    public User getUser(@WebParam(name = "id") String id );
}
