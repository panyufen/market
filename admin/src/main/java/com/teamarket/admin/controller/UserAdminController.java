package com.teamarket.admin.controller;


import com.google.gson.Gson;
import com.teamarket.admin.bean.UserAdminDataBean;
import com.teamarket.admin.model.MarketAdmin;
import com.teamarket.admin.service.impl.UserAdminServiceImpl;
import com.teamarket.common.model.LoginRes;
import com.teamarket.common.model.LoginUser;
import com.teamarket.common.model.base.BaseRes;
import com.teamarket.demo.security.PassToken;
import com.teamarket.demo.security.UserLoginToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAdminController {

    @Autowired
    private UserAdminServiceImpl userAdminService;



    @PassToken
    @RequestMapping("/loginAdmin")
    @ResponseBody
    public String login(@RequestBody LoginUser user) throws Exception{
        BaseRes<LoginRes> resBaseRes = new BaseRes<>();

        UserAdminDataBean userAdminDataBean = userAdminService.login(user);

        resBaseRes.setCode(0);
        resBaseRes.setMsg("success");

        LoginRes<MarketAdmin> loginRes = new LoginRes<>();
        loginRes.setToken(userAdminDataBean.getToken());
        loginRes.setUser(userAdminDataBean.getMarketAdmin());
        resBaseRes.setResult(loginRes);
        return new Gson().toJson(resBaseRes);
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

}
