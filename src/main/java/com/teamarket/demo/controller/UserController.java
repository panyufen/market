package com.teamarket.demo.controller;


import com.google.gson.Gson;
import com.teamarket.common.model.LoginRes;
import com.teamarket.common.model.LoginUser;
import com.teamarket.common.model.base.BaseRes;
import com.teamarket.demo.security.PassToken;
import com.teamarket.demo.security.UserLoginToken;
import com.teamarket.demo.service.impl.UserServiceImpl;

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
    private UserServiceImpl userService;



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
