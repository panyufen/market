package com.teamarket.demo.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.teamarket.demo.dao.UserDao;
import com.teamarket.demo.model.LoginRes;
import com.teamarket.demo.model.LoginUser;
import com.teamarket.demo.model.MarketAdmin;
import com.teamarket.demo.model.base.BaseRes;
import com.teamarket.demo.security.PassToken;
import com.teamarket.demo.security.UserLoginToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${enclosing_method}:${todo} Description &lt;br/&gt;
 * ${todo} Describe applicable conditions of method - Optional.&lt;br/&gt;
 * ${todo} Description of method execution process - Optional.&lt;br/&gt;
 * ${todo} Describe usage of method - Optional.&lt;br/&gt;
 *
 * @exception ${todo}
 * Description &lt;br/&gt;
 * ${tags}
 * ${todo} Description &lt;br/&gt;
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @PassToken
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginUser user) {
        BaseRes<LoginRes> resBaseRes = new BaseRes<>();

        MarketAdmin userInfo = userDao.getUserInfo(user.getName());

        if( userInfo == null ){
            resBaseRes.setCode(1);
            resBaseRes.setMsg("用户不存在");
            return new Gson().toJson(resBaseRes);
        }

        String token = JWT.create().withAudience(userInfo.getId() + "")
                .sign(Algorithm.HMAC256(userInfo.getPassword()));
        resBaseRes.setCode(0);
        resBaseRes.setMsg("success");

        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        loginRes.setUser(userInfo);
        resBaseRes.setResult(loginRes);
        return new Gson().toJson(resBaseRes);
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

}
