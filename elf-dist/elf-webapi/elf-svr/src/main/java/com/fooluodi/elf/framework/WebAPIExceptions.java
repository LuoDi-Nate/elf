package com.fooluodi.elf.framework;


import com.fooluodi.elf.common.exception.Desc;
import com.fooluodi.elf.common.exception.IExceptionCode;

public enum WebAPIExceptions implements IExceptionCode {

	@Desc("无效身份")
	ERR_AUTH_FAILED(),

	@Desc("无效请求")
	ERR_BAD_REQUEST(),

	@Desc("未知错误")
	ERR_UNKNOWN(),

	@Desc("校验错误")
	ERR_WEBAPI_VALIDATION()
}
