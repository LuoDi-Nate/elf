package com.fooluodi.elf.user.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author di
 * elf主要User类
 * 同Do, 不过为了暴露出来 专门包装了dto类
 * */
public class ElfUserDto {
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

    //密码加盐后的md5值 目前默认使用手机号+salt 然后一并md5
    private String password;

    //盐, 目前默认使用字符串 "elf"
    private String salt;

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
        final StringBuffer sb = new StringBuffer("ElfUser{");
        sb.append("id=").append(id);
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", mobileCheck=").append(mobileCheck);
        sb.append(", gender=").append(gender);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", avatarCheck=").append(avatarCheck);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", email='").append(email).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", salt='").append(salt).append('\'');
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
        this.mobile = mobile == null ? null : mobile.trim();
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
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getAvatarCheck() {
        return avatarCheck;
    }

    public void setAvatarCheck(Integer avatarCheck) {
        this.avatarCheck = avatarCheck;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
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
        this.job = job == null ? null : job.trim();
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

    public Date getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(Timestamp signedAt) {
        this.signedAt = signedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}