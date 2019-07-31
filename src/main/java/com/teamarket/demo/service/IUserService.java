package com.teamarket.demo.service;


import com.teamarket.common.model.LoginUser;

public interface IUserService {

    String login(LoginUser user) throws Exception;
}
