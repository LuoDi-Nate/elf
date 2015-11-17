package com.fooluodi.elf.session.mapping;

import com.fooluodi.elf.session.model.Session;
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