package com.fooluodi.elf.common.util.validate.function.handlers;

import java.lang.reflect.Field;

/**
 * Created by di on 19/7/2016.
 * <p>
 * 所有validate annotation的handler都需要实现此方法
 */
public abstract class AbstractHandler {
    /**
     * 统一handler, 针对于不同注解, 可以实现自己的handler
     *
     * @param originBean     原始bean
     * @param field          校验的field
     * @param forceException 是否抛出自定义异常
     * @param exception      自定义异常
     * @param isDeep         是否深度
     * @param <T>
     * @param <E>
     */
    public abstract <T, F extends Field, E extends RuntimeException> void handle(T originBean, F field, boolean forceException, E exception, boolean isDeep);
}
