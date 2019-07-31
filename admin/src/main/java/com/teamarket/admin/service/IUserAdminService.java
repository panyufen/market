package com.teamarket.admin.service;


import com.teamarket.admin.bean.UserAdminDataBean;
import com.teamarket.common.model.LoginUser;

public interface IUserAdminService {

    UserAdminDataBean login(LoginUser user) throws Exception;
}
