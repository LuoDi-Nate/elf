package com.fooluodi.elf.session.model;

import com.fooluodi.elf.common.util.validate.annotation.NotNull;
import com.fooluodi.elf.session.constant.SessionConstant;

import java.sql.Timestamp;

/**
 * @author di 2015年11月15日23:27:25
 * Session对应的do
 * */
public class Session {
    @NotNull
    private Long id;

    private Integer userId;

    private String token;

    /**
     * 登录验证账户, 0:其他, 1:手机号, 2:账户密码, 3:微信
     * @see SessionConstant
     * */
    private Integer loginAccount;

    /**
     * 用户登录设备
     * */
    private String userAgent;

    private String userOs;

    private String userMac;

    private Timestamp expireTime;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Session{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", token='").append(token).append('\'');
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", userAgent='").append(userAgent).append('\'');
        sb.append(", userOs='").append(userOs).append('\'');
        sb.append(", userMac='").append(userMac).append('\'');
        sb.append(", expireTime=").append(expireTime);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(Integer loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserOs() {
        return userOs;
    }

    public void setUserOs(String userOs) {
        this.userOs = userOs;
    }

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}