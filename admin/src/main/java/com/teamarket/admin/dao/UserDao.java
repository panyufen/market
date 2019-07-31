package com.teamarket.admin.dao;


import com.teamarket.admin.model.MarketAdmin;

import org.apache.ibatis.annotations.Param;

/**
 * 首页内容管理自定义Dao
 * Created by macro on 2019/1/28.
 */
public interface UserDao {

    /**
     * 获取用户信息
     */
    MarketAdmin getUserInfo(@Param("username") String username);

    /**
     * 获取用户信息
     */
    MarketAdmin getUserInfoById(@Param("id") String id);


    void updateUserLoginTime(@Param("user") MarketAdmin user);

}
