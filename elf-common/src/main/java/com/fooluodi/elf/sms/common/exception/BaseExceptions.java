package com.fooluodi.elf.sms.common.exception;

public enum BaseExceptions implements IExceptionCode {
	@Desc(value = "未知异常", code = "50000")
	UNKNOWN_EXCEPTION,

	@Desc(value = "用户认证错误:用户登录失败", code = "51001")
	SESSION_VALIDATE_EXCEPTION
}
