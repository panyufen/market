package com.teamarket.admin.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.teamarket.admin.bean.UserAdminDataBean;
import com.teamarket.admin.dao.UserDao;
import com.teamarket.admin.model.MarketAdmin;
import com.teamarket.admin.service.IUserAdminService;
import com.teamarket.common.model.LoginUser;
import com.teamarket.demo.Exception.BadCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("userAdminService")
public class UserAdminServiceImpl implements IUserAdminService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserAdminDataBean login(LoginUser user) throws Exception{

        MarketAdmin userInfo = userDao.getUserInfo(user.getName());

        if( userInfo == null ){
            throw new BadCredentialsException("用户不存在");
        }

        if( !userInfo.getPassword().equals(user.getPwd()) ){
            throw new BadCredentialsException("密码不存在");
        }

        userInfo.setLoginTime(new Timestamp(System.currentTimeMillis()));
        userDao.updateUser(userInfo);

        String token = JWT.create().withAudience(userInfo.getId() + "")

                .sign(Algorithm.HMAC256(userInfo.getPassword()));
        UserAdminDataBean userAdminDataBean = new UserAdminDataBean();
        userAdminDataBean.setToken(token);
        userAdminDataBean.setMarketAdmin(userInfo);

        return userAdminDataBean;
    }
}
