package com.fooluodi.elf.sms.service.impl;

import com.fooluodi.elf.sms.service.ISmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by di on 18/11/15.
 */
public class SmsServiceImpl implements ISmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Value("${mob_appid}")
    private String appId;

    @Value("${mob_url}")
    private String url;

    @Override
    public boolean checkLegality(String phoneNum, String code) {
        logger.info("someone going to check legality, phone:{}, code:{}", phoneNum, code);



        return false;
    }
}
