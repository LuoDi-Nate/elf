package com.fooluodi.elf.user.service;

/**
 * Created by di on 15/11/15.
 * 用户账户service
 */
public interface IUserAccountService {
    /**
     * 用来查看一个手机号是否已经注册为我们用户
     *
     * @param phoneNum
     *
     * @return boolean
     * */
    public boolean isPhoneNew(String phoneNum);

    /**
     * 根据手机号注册新的用户
     * @param phoneNum
     * */
    public void createUserByPhone(String phoneNum);
}
