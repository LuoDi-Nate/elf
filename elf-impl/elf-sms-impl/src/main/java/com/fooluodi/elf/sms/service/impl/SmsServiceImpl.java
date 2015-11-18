package com.fooluodi.elf.sms.service.impl;

import com.fooluodi.elf.sms.exception.ElfSmsExceptionCode;
import com.fooluodi.elf.sms.exception.ElfSmsServiceException;
import com.fooluodi.elf.sms.mob.spi.MobService;
import com.fooluodi.elf.sms.service.ISmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * Created by di on 18/11/15.
 */
public class SmsServiceImpl implements ISmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Value("${mob_appkey}")
    private String appKey;

    @Value("${mob_url}")
    private String url;

    @Resource
    private MobService mobService;

    @Override
    public boolean checkLegality(String phoneNum, String code) {
        logger.info("someone going to check legality, phone:{}, code:{}", phoneNum, code);

        try {
            String mobSmsCheck = mobService.mobSmsCheck(appKey, phoneNum, "86", code, url);
        } catch (Exception e) {
            logger.error("check phone by mob error!", e);
            throw new ElfSmsServiceException(ElfSmsExceptionCode.ERROR_PHOME_CODE_CHECK_FAILED);
        }

        return false;
    }
}
