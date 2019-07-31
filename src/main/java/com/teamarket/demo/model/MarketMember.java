package com.teamarket.demo.model;

import com.teamarket.common.model.base.BaseUser;

import java.sql.Timestamp;

public class MarketMember extends BaseUser {

    private long memberLevelId;
    private String nickname;
    private String phone;
    private long status;
    private java.sql.Timestamp createTime;
    private String icon;
    private long gender;
    private java.sql.Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private long sourceType;
    private long integration;
    private long growth;
    private java.sql.Timestamp loginTime;

    public long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }


    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }


    public long getSourceType() {
        return sourceType;
    }

    public void setSourceType(long sourceType) {
        this.sourceType = sourceType;
    }


    public long getIntegration() {
        return integration;
    }

    public void setIntegration(long integration) {
        this.integration = integration;
    }


    public long getGrowth() {
        return growth;
    }

    public void setGrowth(long growth) {
        this.growth = growth;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

}
