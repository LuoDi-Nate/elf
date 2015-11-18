package com.fooluodi.elf.sms.session.exception;


import com.fooluodi.elf.sms.common.exception.Desc;
import com.fooluodi.elf.sms.common.exception.IExceptionCode;

/**
 * Created by di 2015年11月12日23:29:29
 */
public enum ElfSessionExceptionCode implements IExceptionCode {

	@Desc(value = "生成密码错误", code = "50201")
	ERROR_USER_PASSWD_GEN_ERROR,

	@Desc(value = "注册失败", code = "50202")
	ERROR_REGISTER_FAILED,

	@Desc(value = "该手机号不存在", code = "50203")
	ERROR_PHONE_DOES_NOT_EXIST,

	@Desc(value = "会话过期", code = "50204")
	ERROR_GET_USER_BY_TOKEN,

	@Desc(value = "用户不存在", code = "50205")
	ERROR_GET_USER_BY_USERID,
}
