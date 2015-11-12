package com.fooluodi.elf.user.exception;


import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.exception.IExceptionCode;

/**
 * @author di 2015年11月12日23:30:16
 * 
 */

public class ElfUserSystemException extends ElfSystemException{

	private static final long serialVersionUID = -6422085970425397839L;

	public ElfUserSystemException(IExceptionCode code) {
		super(code);
	}

	public ElfUserSystemException(IExceptionCode code, String message,
			Throwable cause) {
		super(code, message, cause);
	}

	public ElfUserSystemException(IExceptionCode code, String message) {
		super(code, message);
	}

	public ElfUserSystemException(IExceptionCode code, Throwable cause) {
		super(code, cause);
	}
}
