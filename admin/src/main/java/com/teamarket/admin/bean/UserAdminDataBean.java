package com.teamarket.admin.bean;


import com.teamarket.admin.model.MarketAdmin;

public class UserAdminDataBean {

    private String token;

    private MarketAdmin marketAdmin;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MarketAdmin getMarketAdmin() {
        return marketAdmin;
    }

    public void setMarketAdmin(MarketAdmin marketAdmin) {
        this.marketAdmin = marketAdmin;
    }
}
