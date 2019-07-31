package com.teamarket.demo.controller;


import com.google.gson.Gson;
import com.teamarket.common.model.LoginRes;
import com.teamarket.common.model.LoginUser;
import com.teamarket.common.model.base.BaseRes;
import com.teamarket.common.security.PassToken;
import com.teamarket.common.security.UserLoginToken;
import com.teamarket.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    IUserService userService;


    @PassToken
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginUser user) throws Exception{
        BaseRes<LoginRes> resBaseRes = new BaseRes<>();

        String token = userService.login(user);

        resBaseRes.setCode(0);
        resBaseRes.setMsg("success");

        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        resBaseRes.setResult(loginRes);
        return new Gson().toJson(resBaseRes);
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

}
