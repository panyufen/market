package com.teamarket.demo.controller;

import com.teamarket.demo.security.UserLoginToken;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @UserLoginToken
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
