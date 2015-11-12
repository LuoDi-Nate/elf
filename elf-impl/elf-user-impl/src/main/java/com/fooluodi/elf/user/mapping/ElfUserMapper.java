package com.fooluodi.elf.user.mapping;

import com.fooluodi.elf.user.model.ElfUser;

public interface ElfUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ElfUser record);

    int insertSelective(ElfUser record);

    ElfUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ElfUser record);

    int updateByPrimaryKey(ElfUser record);
}