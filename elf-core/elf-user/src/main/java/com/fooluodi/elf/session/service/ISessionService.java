package com.fooluodi.elf.session.service;

import com.fooluodi.elf.session.dto.SessionLogger;

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
     *
     * @param token
     *
     * */
    public void getUserByToken(String token);
}
