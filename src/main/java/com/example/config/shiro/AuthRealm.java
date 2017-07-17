package com.example.config.shiro;

import com.example.mapper.UserRoleMapper;
import com.example.mapper.entity.Module;
import com.example.mapper.entity.Role;
import com.example.mapper.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ThinkPad on 2017/7/17.
 * 登录认证和授权。
 */
public class AuthRealm  extends AuthorizingRealm {

    @Autowired
    private UserRoleMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user= (User) principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions=new ArrayList<>();
        Set<Role> roles=user.getRoles();
        List<String> userHasRole=new ArrayList<>();
        if(roles!=null && !roles.isEmpty()){
            roles.forEach(role -> {
                userHasRole.add(role.getRname());   //增加用户角色。
                Set<Module> modules=role.getModules();
                if(modules!=null &&!modules.isEmpty()){
                    modules.forEach(module -> {
                        permissions.add(module.getMname());  //增加用户权限
                    });
                }
            });
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo  ();
        info.addStringPermissions(permissions);
        info.addRoles(userHasRole);
        return info;
    }
    //认证 登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken passwordToken= (UsernamePasswordToken) token;
        String username=passwordToken.getUsername();
        User user=userMapper.findByUserName(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
