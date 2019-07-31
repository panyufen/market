package com.teamarket.demo.controller;

import com.google.gson.Gson;
import com.teamarket.common.model.base.BaseRes;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${enclosing_method}:${todo} Description &lt;br/&gt;
 * ${todo} Describe applicable conditions of method - Optional.&lt;br/&gt;
 * ${todo} Description of method execution process - Optional.&lt;br/&gt;
 * ${todo} Describe usage of method - Optional.&lt;br/&gt;
 *
 * Description &lt;br/&gt;
 * ${tags}
 * ${todo} Description &lt;br/&gt;
 */
@Controller
public class CustomErrorController implements ErrorController {


    @RequestMapping("/errors")
    public String error(){
        BaseRes resBaseRes = new BaseRes();
        resBaseRes.setCode(1);
        resBaseRes.setMsg("error");
        return new Gson().toJson(resBaseRes);
    }

    @Override
    public String getErrorPath() {
        return "/errors";
    }
}
