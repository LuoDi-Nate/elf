package com.fooluodi.elf.session.service.impl;

import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.common.util.time.DateUtil;
import com.fooluodi.elf.session.dto.SessionLogger;
import com.fooluodi.elf.session.exception.ElfSessionExceptionCode;
import com.fooluodi.elf.session.exception.ElfSessionServiceException;
import com.fooluodi.elf.session.mapping.SessionMapper;
import com.fooluodi.elf.session.model.Session;
import com.fooluodi.elf.session.service.ISessionService;
import com.fooluodi.elf.user.dto.ElfUserInnerDto;
import com.fooluodi.elf.user.service.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by di on 15/11/15.
 */
@Service
public class SessionServiceImpl implements ISessionService {
    private static final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

    //token过期时间 30天
    private static int SESSION_EXPIRE_DAY = 30;

    @Resource
    private SessionMapper sessionMapper;

    @Resource
    private IUserAccountService userAccountService;

    @Override
    public String addSessionForSomeone(SessionLogger sessionLogger) {
        logger.info("going to create session for :{}", sessionLogger);

        Session session = new Session();

        session.setUserId(sessionLogger.getUserId());

        String token = UUID.randomUUID().toString();
        logger.info("create token :{}", token);
        session.setToken(token);

        session.setUserAgent(sessionLogger.getUserAgent());
        session.setUserOs(sessionLogger.getUserOs());
        session.setUserMac(sessionLogger.getUserMac());

        //生成过期时间
        Timestamp timeExpire = new Timestamp(System.currentTimeMillis());
        Date date = DateUtil.addDay(new Date(), SESSION_EXPIRE_DAY);
        timeExpire.setTime(date.getTime());
        session.setExpireTime(timeExpire);
        logger.info("set expireTime:{}, for token:{}", timeExpire, token);

        session.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        try {
            sessionMapper.insert(session);
        } catch (Exception e) {
            logger.error("create session for id:{} error!", sessionLogger.getUserId(), e);
            throw e;
        }

        return token;
    }

    @Override
    public ElfUserInnerDto getUserByToken(String token) throws ElfServiceException {
        //TODO 从redis重获取

        //如果从redis重未查到用户, 降级去db中查找
        Session sessionByToken = null;
        try {
            sessionByToken = sessionMapper.getSessionByToken(token);

            Assert.notNull(sessionByToken, "get session failed!");

            //查看token是否过期
            Assert.isTrue(sessionByToken.getExpireTime().getTime() > System.currentTimeMillis(), "token over expire time!");
        } catch (Exception e) {
            logger.error("get session by token:{} error.", e);
            throw new ElfSessionServiceException(ElfSessionExceptionCode.ERROR_GET_USER_BY_TOKEN);
        }

        ElfUserInnerDto userByUserId = userAccountService.getUserByUserId(sessionByToken.getUserId());

        return userByUserId;
    }
}
