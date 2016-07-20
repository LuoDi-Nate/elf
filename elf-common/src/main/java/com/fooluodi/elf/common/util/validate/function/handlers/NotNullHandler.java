package com.fooluodi.elf.common.util.validate.function.handlers;

import com.fooluodi.elf.common.util.validate.ValidateException.ValidateException;

import java.lang.reflect.Field;

/**
 * Created by di on 19/7/2016.
 */
public class NotNullHandler extends AbstractHandler {
    public <T, F extends Field, E extends RuntimeException> void handle(T originBean, F field, boolean forceException, E exception, boolean isDeep) {
        if (isDeep) {
            deepCheck(originBean, field, forceException, exception);
        } else {
            normalCheck(originBean, field, forceException, exception);
        }
    }

    private static <T, F extends Field, E extends RuntimeException> void deepCheck(T originBean, F field, boolean forceException, E exception) {
        // TODO: 20/7/2016 日后支持深度
        System.out.println("not support deep check now.");
    }


    private static <T, F extends Field, E extends RuntimeException> void normalCheck(T originBean, F field, boolean forceException, E exception) {
        String beanName = originBean.getClass().getName();
        String fieldName = field.getName();

        boolean isNull = false;
        try {
            field.setAccessible(true);
            Object o = field.get(originBean);
            if (o == null) isNull = true;
        } catch (IllegalAccessException e) {
            isNull = true;
        }

        if (isNull) {
            throw forceException ? exception : new ValidateException(String.format("%s 's field :%s can not be null!", beanName, fieldName));
        }
    }


}
