package com.fooluodi.elf.user.exception;


import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:29:22
 * 
 */

public class ElfUserServiceException extends ElfSystemException {

	private static final long serialVersionUID = -8598682047988760813L;
	
	public ElfUserServiceException(IExceptionCode code) {
		super(code);
	}

	public ElfUserServiceException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfUserServiceException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfUserServiceException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}

}
