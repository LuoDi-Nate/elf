package com.fooluodi.elf.sms.session.service;

import com.fooluodi.elf.sms.common.exception.ElfServiceException;
import com.fooluodi.elf.sms.session.dto.SessionLogger;
import com.fooluodi.elf.sms.user.dto.ElfUserDto;

/**
 * Created by di on 13/11/15.
 * session管理模块
 * 提供关于session的查看, 写入, 包括将热点数据写入redis的服务
 */
public interface ISessionService {
    /**
     *  为登录用户生成session信息
     *  并返回token
     *
     *  @param sessionLogger
     *
     *  @return String --> ACCESS-TOKEN
     * */
    public String addSessionForSomeone(SessionLogger sessionLogger);


    /**
     * 根据token(ACCESS_TOKEN)信息获取User对象
     * 会尝试从redis中通过token来查找userId,
     * redis的热数据是可降级的, 如果从redis中没有找到, 会去db中查找, 如果仍没有, 会抛出serviceException
     *
     * @param token
     *
     * @return 该token对应的User
     * */
    public ElfUserDto getUserByToken(String token) throws ElfServiceException;
}
