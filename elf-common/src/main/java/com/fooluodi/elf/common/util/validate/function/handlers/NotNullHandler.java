package com.fooluodi.elf.common.util.validate.function.handlers;

import java.lang.reflect.Field;

/**
 * Created by di on 19/7/2016.
 */
public class NotNullHandler extends AbstractHandler {
    public <T, F extends Field, E extends RuntimeException> void handle(T originBean, F field, boolean forceException, E exception, boolean isDeep) {
        System.out.println(originBean);
        System.out.println(field);
        System.out.println(forceException);
        System.out.println(exception);
        System.out.println(isDeep);
    }

}
