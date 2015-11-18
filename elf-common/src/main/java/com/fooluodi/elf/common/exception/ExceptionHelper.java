package com.fooluodi.elf.common.exception;

import java.lang.reflect.Field;

/**
 * @author di
 *
 * 自动解析Desc注解中的异常描述和code
 * @see Desc
 * */
public class ExceptionHelper {
	public static String getMessage(IExceptionCode code) {
		if (code == null)
			code = BaseExceptions.UNKNOWN_EXCEPTION;
		try {
			Field field = code.getClass().getField(code.name());
			Desc descAnnotation = field.getAnnotation(Desc.class);
			if (descAnnotation == null)
				return code.name();
			else if (descAnnotation.value() == null || "".equals(descAnnotation.value().trim()))
				return code.name();
			else
				return descAnnotation.value();
		} catch (Throwable e) {
			return code.name();
		}
	}

	public static String getCode(IExceptionCode code) {
		if (code == null){
			code = BaseExceptions.UNKNOWN_EXCEPTION;
		}
		try{
			Field field = code.getClass().getField(code.name());
			Desc descAnnotation = field.getAnnotation(Desc.class);
			if (descAnnotation == null)
				return code.name();
			else if (descAnnotation.value() == null || "".equals(descAnnotation.value().trim()))
				return code.name();
			else
				return descAnnotation.code();
		}catch (Throwable e){
			return code.name();
		}
	}
}
