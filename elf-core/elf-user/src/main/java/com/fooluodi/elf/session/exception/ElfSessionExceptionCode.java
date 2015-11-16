package com.fooluodi.elf.session.exception;


import com.fooluodi.elf.common.exception.Desc;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * Created by di 2015年11月12日23:29:29
 */
public enum ElfSessionExceptionCode implements IExceptionCode {

	@Desc(value = "生成密码错误", code = "50201")
	ERROR_USER_PASSWD_GEN_ERROR,

	@Desc(value = "注册失败", code = "50202")
	ERROR_REGISTER_FAILED,
}
