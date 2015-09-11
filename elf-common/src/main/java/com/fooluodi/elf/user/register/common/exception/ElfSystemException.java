package com.fooluodi.elf.user.register.common.exception;


/**
 * Created by di on 7/8/15.
 */
public class ElfSystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected String errorCode;

    protected String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ElfSystemException(IExceptionCode code) {
        super(ExceptionHelper.getMessage(code));
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = this.getMessage();
    }

    public ElfSystemException(IExceptionCode code, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = ExceptionHelper.getMessage(code);
    }

    public ElfSystemException(IExceptionCode code, String message) {
        super(message);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = ExceptionHelper.getMessage(code);
    }

    public ElfSystemException(IExceptionCode code, Throwable cause) {
        super(ExceptionHelper.getMessage(code), cause);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = this.getMessage();
    }
}
