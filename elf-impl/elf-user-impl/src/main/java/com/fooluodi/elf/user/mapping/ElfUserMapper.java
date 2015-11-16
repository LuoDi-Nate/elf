package com.fooluodi.elf.user.mapping;

import com.fooluodi.elf.user.model.ElfUser;
import org.apache.ibatis.annotations.Param;

public interface ElfUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ElfUser record);

    int insertSelective(ElfUser record);

    ElfUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ElfUser record);

    int updateByPrimaryKey(ElfUser record);

    /**
     * 通过手机号查找用户
     * */
    //TODO 补全xml
    ElfUser getUserByPhoneNum(@Param("phoneNUm") String phoneNum);
}