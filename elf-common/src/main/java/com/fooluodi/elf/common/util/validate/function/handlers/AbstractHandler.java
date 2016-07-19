package com.fooluodi.elf.common.util.validate.function.handlers;

import java.lang.reflect.Field;

/**
 * Created by di on 19/7/2016.
 *
 * 所有validate annotation的handler都需要实现此方法
 */
public abstract class AbstractHandler {
    abstract <T extends Field, E extends RuntimeException> void handle(T field, E exception);
}
