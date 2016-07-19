package com.fooluodi.elf.common.util.validate.ValidateException;

/**
 * Created by di on 19/7/2016.
 */
public class ValidateException extends RuntimeException {
    public ValidateException() {
        super();
    }

    public ValidateException(String msg) {
        super(msg);
    }

    public ValidateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
