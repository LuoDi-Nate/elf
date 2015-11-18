package com.fooluodi.elf.sms.exception;


import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:29:22
 * 
 */

public class ElfSmsServiceException extends ElfSystemException {

	private static final long serialVersionUID = -8598682047988760813L;
	
	public ElfSmsServiceException(IExceptionCode code) {
		super(code);
	}

	public ElfSmsServiceException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfSmsServiceException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfSmsServiceException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}

}
