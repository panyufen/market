package com.teamarket.demo.Exception;

import com.teamarket.demo.model.base.BaseRes;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseRes defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        BaseRes baseRes = new BaseRes();
        baseRes.setCode(1);
        baseRes.setMsg(e.getMessage());
        return baseRes;
    }

}