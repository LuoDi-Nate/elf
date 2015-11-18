package com.fooluodi.elf.sms.user.service.impl;

import com.fooluodi.elf.sms.common.exception.ElfServiceException;
import com.fooluodi.elf.sms.session.constant.SessionConstant;
import com.fooluodi.elf.sms.session.dto.SessionLogger;
import com.fooluodi.elf.sms.session.service.ISessionService;
import com.fooluodi.elf.sms.user.dto.ElfUserDto;
import com.fooluodi.elf.sms.user.dto.UserLogInByPhoneCheckDto;
import com.fooluodi.elf.sms.user.service.IUserAccountService;
import com.fooluodi.elf.sms.user.service.ILogInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by di on 13/11/15.
 */
@Service
public class LogInServiceImpl implements ILogInService {
    private static final Logger logger = LoggerFactory.getLogger(LogInServiceImpl.class);

    @Resource
    private ISessionService sessionService;

    @Resource
    private IUserAccountService userAccountService;

    @Override
    public String loginUserByPhoneCheck(UserLogInByPhoneCheckDto userLogInByPhoneCheckDto) throws ElfServiceException {
        logger.info("a new user sign in by phone, {}", userLogInByPhoneCheckDto);

        //TODO 调用短信验证模块, 看验证码是否通过

        //如果校验通过, 查看手机号是否注册
        if (userAccountService.isPhoneNew(userLogInByPhoneCheckDto.getTarget_phone())) {
            //该手机号并没有注册 注册新用户
            logger.info("phone :{} is not register, register now.", userLogInByPhoneCheckDto.getTarget_phone());
            userAccountService.createUserByPhone(userLogInByPhoneCheckDto.getTarget_phone());
        }

        //能走到这里, 该手机号一定对应一个user
        ElfUserDto uesrByPhone = userAccountService.getUesrByPhone(userLogInByPhoneCheckDto.getTarget_phone());

        //生成session, 调用session模块, 返回前端
        SessionLogger sessionLogger = new SessionLogger();
        sessionLogger.setUserMac(userLogInByPhoneCheckDto.getUser_mac());
        sessionLogger.setUserOs(userLogInByPhoneCheckDto.getUser_os());
        sessionLogger.setUserAgent(userLogInByPhoneCheckDto.getUsera_agent());
        sessionLogger.setLogInWay(SessionConstant.LOGIN_BY_PHONE);

        sessionLogger.setUserId(uesrByPhone.getId());
        String token = sessionService.addSessionForSomeone(sessionLogger);

        return token;
    }
}