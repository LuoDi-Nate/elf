package com.fooluodi.elf.user.dto;

/**
 * Created by di on 13/11/15.
 * 用户使用短信登录的dto
 */
public class UserLogInByPhoneCheckDto {
    private String target_phone;

    //短信验证码
    private String code;

    //用户的登录设备
    private String usera_agent;

    //用户操作系统
    private String user_os;

    //用户的mac地址
    private String user_mac;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserLogInByPhoneCheckDto{");
        sb.append("target_phone='").append(target_phone).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", usera_agent='").append(usera_agent).append('\'');
        sb.append(", user_os='").append(user_os).append('\'');
        sb.append(", user_mac='").append(user_mac).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getTarget_phone() {
        return target_phone;
    }

    public void setTarget_phone(String target_phone) {
        this.target_phone = target_phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsera_agent() {
        return usera_agent;
    }

    public void setUsera_agent(String usera_agent) {
        this.usera_agent = usera_agent;
    }

    public String getUser_os() {
        return user_os;
    }

    public void setUser_os(String user_os) {
        this.user_os = user_os;
    }

    public String getUser_mac() {
        return user_mac;
    }

    public void setUser_mac(String user_mac) {
        this.user_mac = user_mac;
    }
}
