package com.fooluodi.elf.user.service;

import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.user.dto.UserLogInByPhoneCheckDto;

/**
 * Created by di on 13/11/15.
 * 用户登录的service
 * 各种形式的认证登录最终都会添加在这里
 */
public interface ILogInService {
    /**
     * 用户使用短信认证登录
     *
     * @param userLogInByPhoneCheckDto
     *
     * @return String sessionCode  --> ACCESS_TOKEN
     * */
    public String loginUserByPhoneCheck(UserLogInByPhoneCheckDto userLogInByPhoneCheckDto) throws ElfServiceException;
}
