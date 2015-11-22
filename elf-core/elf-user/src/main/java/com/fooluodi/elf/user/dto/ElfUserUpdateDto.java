package com.fooluodi.elf.user.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by di on 22/11/15.
 * 用户能够随意修改的个人信息类, 密码/手机号/账户 单独开放接口修改
 */
public class ElfUserUpdateDto {
    private Integer id;

    private Integer gender;

    private String avatar;

    private Timestamp birthDay;

    private String email;

    //用户一句话签名
    private String signature;

    //邀请者id
    private Integer inviterId;

    private BigDecimal height;

    private String job;

    private Integer salary;

    private Integer hometownCityId;

    private Integer livingCityId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ElfUserUpdateDto{");
        sb.append("id=").append(id);
        sb.append(", gender=").append(gender);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", email='").append(email).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", inviterId=").append(inviterId);
        sb.append(", height=").append(height);
        sb.append(", job='").append(job).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", hometownCityId=").append(hometownCityId);
        sb.append(", livingCityId=").append(livingCityId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getHometownCityId() {
        return hometownCityId;
    }

    public void setHometownCityId(Integer hometownCityId) {
        this.hometownCityId = hometownCityId;
    }

    public Integer getLivingCityId() {
        return livingCityId;
    }

    public void setLivingCityId(Integer livingCityId) {
        this.livingCityId = livingCityId;
    }
}
