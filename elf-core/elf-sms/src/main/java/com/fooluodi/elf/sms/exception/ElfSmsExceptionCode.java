package com.fooluodi.elf.sms.exception;


import com.fooluodi.elf.common.exception.Desc;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * Created by di 2015年11月12日23:29:29
 */
public enum ElfSmsExceptionCode implements IExceptionCode {

	@Desc(value = "短信验证码校验失败", code = "50501")
	ERROR_PHOME_CODE_CHECK_FAILED,

}
