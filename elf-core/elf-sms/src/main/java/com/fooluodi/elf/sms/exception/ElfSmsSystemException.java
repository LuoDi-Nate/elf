package com.fooluodi.elf.sms.exception;


import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:30:16
 * 
 */

public class ElfSmsSystemException extends ElfSystemException{

	private static final long serialVersionUID = -6422085970425397839L;

	public ElfSmsSystemException(IExceptionCode code) {
		super(code);
	}

	public ElfSmsSystemException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfSmsSystemException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfSmsSystemException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}
}
