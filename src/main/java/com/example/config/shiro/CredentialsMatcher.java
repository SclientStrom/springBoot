package com.example.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by ThinkPad on 2017/7/17.
 * 密码验证。
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken passwordToken= (UsernamePasswordToken) token;
        String inputPassword=new String(passwordToken.getPassword());
        String dbPassword= (String) info.getCredentials();
        return this.equals(inputPassword,dbPassword);
    }
}
