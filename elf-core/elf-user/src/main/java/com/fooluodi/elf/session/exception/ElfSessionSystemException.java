package com.fooluodi.elf.session.exception;


import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:30:16
 * 
 */

public class ElfSessionSystemException extends ElfSystemException{

	private static final long serialVersionUID = -6422085970425397839L;

	public ElfSessionSystemException(IExceptionCode code) {
		super(code);
	}

	public ElfSessionSystemException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfSessionSystemException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfSessionSystemException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}
}
