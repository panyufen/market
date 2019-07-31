package com.teamarket.demo.controller;

import com.teamarket.demo.security.UserLoginToken;

import org.springframework.stereotype.Controller;
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
public class MainController {

    @UserLoginToken
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
