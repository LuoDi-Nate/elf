package com.fooluodi.elf.user.service.impl;

import com.fooluodi.elf.user.dto.UserLogInByPhoneCheckDto;
import com.fooluodi.elf.user.service.ILogInService;

/**
 * Created by di on 13/11/15.
 */
public class LogInServiceImpl implements ILogInService {
    @Override
    public String loginUserByPhoneCheck(UserLogInByPhoneCheckDto userLogInByPhoneCheckDto) {
        //调用短信验证模块, 看验证码是否通过

        //生成session, 调用session模块, 返回前端

        return null;
    }
}
