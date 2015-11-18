package com.fooluodi.elf.sms.session.dto;

/**
 * Created by di on 13/11/15.
 *
 * 写入session的dto
 */
public class SessionLogger {
    private int userId;
    private String userAgent;
    private String userOs;
    private String userMac;

    //登录验证账户, 0:其他, 1:手机号, 2:账户密码, 3:微信
    private int logInWay;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SessionLogger{");
        sb.append("userId=").append(userId);
        sb.append(", userAgent='").append(userAgent).append('\'');
        sb.append(", userOs='").append(userOs).append('\'');
        sb.append(", userMac='").append(userMac).append('\'');
        sb.append(", logInWay=").append(logInWay);
        sb.append('}');
        return sb.toString();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getLogInWay() {
        return logInWay;
    }

    public void setLogInWay(int logInWay) {
        this.logInWay = logInWay;
    }
}
