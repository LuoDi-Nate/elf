package com.fooluodi.elf.sms.session.mapping;

import com.fooluodi.elf.sms.session.model.Session;
import org.apache.ibatis.annotations.Param;

public interface SessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

    Session getSessionByToken(@Param("token") String token);
}