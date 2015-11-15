package com.fooluodi.elf.user.service.impl;

import com.fooluodi.elf.user.mapping.ElfUserMapper;
import com.fooluodi.elf.user.model.ElfUser;
import com.fooluodi.elf.user.service.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by di on 16/11/15.
 */
@Service
public class UserAccountServiceImpl implements IUserAccountService{
    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    @Resource
    private ElfUserMapper userMapper;

    @Override
    public boolean isPhoneNew(String phoneNum) {
        logger.info("going to check phoneNum is register for :{}", phoneNum);

        ElfUser userByPhoneNum = null;
        try {
            userByPhoneNum = userMapper.getUserByPhoneNum(phoneNum);
        }catch (Exception e){
            logger.error("get user by phone error", e);
        }

        return userByPhoneNum == null;
    }

    @Override
    public void createUserByPhone(String phoneNum) {
        logger.info("going to create User for phone:{}", phoneNum);

        ElfUser user = new ElfUser();
        //TODO

    }
}
