package com.teamarket.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.teamarket.common.Exception.BadCredentialsException;
import com.teamarket.common.model.LoginUser;
import com.teamarket.demo.dao.UserDao;
import com.teamarket.demo.model.MarketMember;
import com.teamarket.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String login(LoginUser user) throws Exception{

        MarketMember userInfo = userDao.getUserInfo(user.getName());

        if( userInfo == null ){
            throw new BadCredentialsException("用户不存在");
        }

        if( !userInfo.getPassword().equals(user.getPwd()) ){
            throw new BadCredentialsException("密码不存在");
        }

        userInfo.setLoginTime(new Timestamp(System.currentTimeMillis()));
        userDao.updateUserLoginTime(userInfo);

        String token = JWT.create().withAudience(String.valueOf(userInfo.getId()),"member")
                .sign(Algorithm.HMAC256(userInfo.getPassword()));

        return token;
    }
}
