package com.fooluodi.elf.user.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author di
 * elf主要User类
 * 除了无密码字段外同Do
 * 用户filter内部填充User使用, 与前端交互不要使用此类
 * */
public class ElfUserInnerDto {
    private Integer id;

    private String mobile;

    //手机号是否通过验证
    private Integer mobileCheck;

    private Integer gender;

    private String avatar;

    //头像是否通过审核
    private Integer avatarCheck;

    private Timestamp birthDay;

    private String email;

    //账号,做唯一校验
    private String account;

    //用户一句话签名
    private String signature;

    //邀请者id
    private Integer inviterId;

    private BigDecimal height;

    private String job;

    private Integer salary;

    private Integer hometownCityId;

    private Integer livingCityId;

    private Timestamp signedAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ElfUserInnerDto{");
        sb.append("id=").append(id);
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", mobileCheck=").append(mobileCheck);
        sb.append(", gender=").append(gender);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", avatarCheck=").append(avatarCheck);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", email='").append(email).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", inviterId=").append(inviterId);
        sb.append(", height=").append(height);
        sb.append(", job='").append(job).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", hometownCityId=").append(hometownCityId);
        sb.append(", livingCityId=").append(livingCityId);
        sb.append(", signedAt=").append(signedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getMobileCheck() {
        return mobileCheck;
    }

    public void setMobileCheck(Integer mobileCheck) {
        this.mobileCheck = mobileCheck;
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

    public Integer getAvatarCheck() {
        return avatarCheck;
    }

    public void setAvatarCheck(Integer avatarCheck) {
        this.avatarCheck = avatarCheck;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Timestamp getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(Timestamp signedAt) {
        this.signedAt = signedAt;
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