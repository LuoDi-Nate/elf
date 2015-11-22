package com.fooluodi.elf.user.exception;


import com.fooluodi.elf.common.exception.Desc;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * Created by di 2015年11月12日23:29:29
 */
public enum ElfUserExceptionCode implements IExceptionCode {

	@Desc(value = "查询错误", code = "50200")
	ERROR_QUERY,

	@Desc(value = "更新个人信息失败", code = "50201")
	ERROR_UPDATE_USER_PROFILE,
}
