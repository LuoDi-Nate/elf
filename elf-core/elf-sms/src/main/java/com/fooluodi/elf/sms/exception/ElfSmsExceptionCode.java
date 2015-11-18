package com.fooluodi.elf.sms.exception;


import com.fooluodi.elf.common.exception.Desc;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * Created by di 2015年11月12日23:29:29
 */
public enum ElfSmsExceptionCode implements IExceptionCode {

	@Desc(value = "短信验证码校验失败", code = "50501")
	ERROR_PHOME_CODE_CHECK_FAILED,

	@Desc(value = "AppKey为空", code = "51405")
	MOB_HAS_NO_APPKEY,

	@Desc(value = "AppKey无效", code = "406")
	MOB_INVALID_APPKEY,

	@Desc(value = "国家代码或手机号码为空", code = "456")
	MOB_NO_ZONE,

	@Desc(value = "手机号码格式错误", code = "457")
	MOB_INVALID_PHONE_NUMBER,

	@Desc(value = "请求校验的验证码为空", code = "466")
	MOB_NO_CODE,

	@Desc(value = "请求校验验证码频繁", code = "467")
	MOB_TOO_MANY_TIMES,

	@Desc(value = "验证码错误", code = "468")
	MOB_WRONG_CODE,

	@Desc(value = "没有打开服务端验证开关", code = "474")
	MOB_NOT_ACCESS_OPTION,

}
