package com.teamarket.demo.model;

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
public class LoginRes {

    private String token;

    private MarketAdmin user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MarketAdmin getUser() {
        return user;
    }

    public void setUser(MarketAdmin user) {
        this.user = user;
    }
}
