package com.fooluodi.elf.user.register.common.exception;

public enum BaseExceptions implements IExceptionCode {
	@Desc("未知异常")
	UNKNOWN_EXCEPTION,

	@Desc("用户认证错误:用户登录失败")
	SESSION_VALIDATE_EXCEPTION
}
