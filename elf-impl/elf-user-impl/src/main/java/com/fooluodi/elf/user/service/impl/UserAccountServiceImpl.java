package com.fooluodi.elf.user.service.impl;

import com.fooluodi.elf.common.constant.ElfConstant;
import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.session.exception.ElfSessionExceptionCode;
import com.fooluodi.elf.user.dto.ElfUserDto;
import com.fooluodi.elf.user.mapping.ElfUserMapper;
import com.fooluodi.elf.user.model.ElfUser;
import com.fooluodi.elf.user.service.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

/**
 * Created by di on 16/11/15.
 */
@Service
public class UserAccountServiceImpl implements IUserAccountService {
    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    @Resource
    private ElfUserMapper userMapper;

    @Override
    public boolean isPhoneNew(String phoneNum) {
        logger.info("going to check phoneNum is register for :{}", phoneNum);

        ElfUser userByPhoneNum = null;
        try {
            userByPhoneNum = userMapper.getUserByPhoneNum(phoneNum);
        } catch (Exception e) {
            logger.error("get user by phone error", e);
        }

        return userByPhoneNum == null;
    }

    @Override
    public void createUserByPhone(String phoneNum) throws ElfServiceException {
        logger.info("going to create User for phone:{}", phoneNum);

        ElfUser user = new ElfUser();
        user.setMobile(phoneNum);
        user.setMobileCheck(ElfConstant.YES);
        user.setSalt("elf");

        //生成密码md5, 默认使用手机号, 添加盐后md5, 盐默认使用elf字符串
        String originPass = phoneNum + "elf";
        String afterMd5Pass = null;

        try {
            afterMd5Pass = DigestUtils.md5DigestAsHex(originPass.getBytes("UTF-8"));

            Assert.notNull(afterMd5Pass, "gen password error!");
        } catch (UnsupportedEncodingException e) {
            logger.error("get md5 error , origin string :{}", originPass);
            throw new ElfServiceException(ElfSessionExceptionCode.ERROR_USER_PASSWD_GEN_ERROR);
        }

        user.setPassword(afterMd5Pass);
        user.setSignedAt(new Timestamp(System.currentTimeMillis()));
        //填充一个默认账号, 手机号加当前时间戳
        user.setAccount(phoneNum + System.currentTimeMillis());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        try {
            userMapper.insert(user);
        }catch (Exception e){
            logger.error("create user error!", e);
            throw new ElfServiceException(ElfSessionExceptionCode.ERROR_REGISTER_FAILED);
        }
    }

    @Override
    public ElfUserDto getUesrByPhone(String phoneNum) throws ElfServiceException {
        logger.info("get user by phone :", phoneNum);

        ElfUserDto returnUser = new ElfUserDto();

        try {
            ElfUser userByPhoneNum = userMapper.getUserByPhoneNum(phoneNum);

            BeanUtils.copyProperties(userByPhoneNum, returnUser);

        }catch (Exception e){
            logger.error("get user by phone error!", e);
            throw new ElfServiceException(ElfSessionExceptionCode.ERROR_PHONE_DOES_NOT_EXIST);
        }

        return returnUser;
    }
}
