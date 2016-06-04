package com.fooluodi.elf.sms.service.impl;

import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.common.util.JsonHelper;
import com.fooluodi.elf.sms.exception.ElfSmsExceptionCode;
import com.fooluodi.elf.sms.exception.ElfSmsServiceException;
import com.fooluodi.elf.sms.mob.MobConstant;
import com.fooluodi.elf.sms.mob.MobReturnDto;
import com.fooluodi.elf.sms.mob.spi.MobService;
import com.fooluodi.elf.sms.service.ISmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by di on 18/11/15.
 */
@Service
public class SmsServiceImpl implements ISmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Value("${mob_appkey}")
    private String appKey;

    @Value("${mob_url}")
    private String url;

    @Resource
    private MobService mobService;

    @Override
    public boolean checkLegality(String phoneNum, String code) throws ElfServiceException {
        logger.info("someone going to check legality, phone:{}, code:{}", phoneNum, code);

        String mobSmsCheck = null;
        try {
            mobSmsCheck = mobService.mobSmsCheck(appKey, phoneNum, "86", code, url);

            Assert.notNull(mobSmsCheck, "check phone by mob error");
        } catch (Exception e) {
            logger.error("check phone by mob error!", e);
            throw new ElfSmsServiceException(ElfSmsExceptionCode.ERROR_PHOME_CODE_CHECK_FAILED);
        }

        logger.info("get mob return message :{}", mobSmsCheck);

        MobReturnDto mobReturnDto = JsonHelper.transJsonStringToObj(mobSmsCheck, MobReturnDto.class);

        //只要不是成功 送去包装Exception
        if(!Objects.equals(mobReturnDto.getStatus(), MobConstant.MOB_SUCCESS)){
            ElfServiceException elfServiceException = convertReturnDto(mobReturnDto);
            logger.error("mob sms service check error!", elfServiceException);
            throw elfServiceException;
        }

        return true;
    }

    /**
     * 将非成功的返回, 送到这里, 返回正确的Exception
     * @see ElfSmsExceptionCode
     * */
    private ElfServiceException convertReturnDto(MobReturnDto mobReturnDto){
        switch (mobReturnDto.getStatus()){
            case MobConstant.MOB_HAS_NO_APPKEY:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_HAS_NO_APPKEY);

            case MobConstant.MOB_INVALID_APPKEY:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_INVALID_APPKEY);

            case MobConstant.MOB_INVALID_PHONE_NUMBER:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_INVALID_PHONE_NUMBER);

            case MobConstant.MOB_NO_CODE:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_NO_CODE);

            case MobConstant.MOB_NOT_ACCESS_OPTION:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_NOT_ACCESS_OPTION);

            case MobConstant.MOB_NO_ZONE:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_NO_ZONE);

            case MobConstant.MOB_WRONG_CODE:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_WRONG_CODE);

            case MobConstant.MOB_TOO_MANY_TIMES:
                return new ElfSmsServiceException(ElfSmsExceptionCode.MOB_TOO_MANY_TIMES);

            default:
                return new ElfSmsServiceException(ElfSmsExceptionCode.ERROR_PHOME_CODE_CHECK_FAILED);
        }
    }
}
