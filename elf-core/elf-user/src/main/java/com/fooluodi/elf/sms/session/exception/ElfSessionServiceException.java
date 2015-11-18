package com.fooluodi.elf.sms.session.exception;


import com.fooluodi.elf.sms.common.exception.ElfSystemException;
import com.fooluodi.elf.sms.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:29:22
 * 
 */

public class ElfSessionServiceException extends ElfSystemException {

	private static final long serialVersionUID = -8598682047988760813L;
	
	public ElfSessionServiceException(IExceptionCode code) {
		super(code);
	}

	public ElfSessionServiceException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfSessionServiceException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfSessionServiceException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}

}
