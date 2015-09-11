package me.ele.minos.framework;


import com.fooluodi.elf.register.common.exception.Desc;
import com.fooluodi.elf.register.common.exception.IExceptionCode;

public enum WebAPIExceptions implements IExceptionCode {

	@Desc("无效身份")
	ERR_AUTH_FAILED(),

	@Desc("无效请求")
	ERR_BAD_REQUEST(),

	@Desc("未知错误")
	ERR_UNKNOWN(),

	@Desc("校验错误")
	ERR_WEBAPI_VALIDATION(),

	@Desc("找不到access_token")
	ERR_WEBAPI_ACCESS_TOKEN_NOT_FOUND(),

	@Desc("当前用户没有业务包")
	ERR_NO_SOURCE_UNIT_FOR_KARMA_USER();

}
